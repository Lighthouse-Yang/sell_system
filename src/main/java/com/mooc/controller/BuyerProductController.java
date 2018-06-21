package com.mooc.controller;

import com.mooc.VO.ProductInfoVO;
import com.mooc.VO.ProductVO;
import com.mooc.VO.ResultVO;
import com.mooc.dataobject.ProductCategory;
import com.mooc.dataobject.ProductInfo;
import com.mooc.service.CategoryService;
import com.mooc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mooc.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author yangbo
 * 2018-06-17 0:27
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询所有下架商品
        //List<ProductInfo> productInfoList = productService.findDownAll();

        //2.查询类目(一次性查询)
        //List<Integer> categoryTypeList = new ArrayList<>();


        //传统方法
        //       for (ProductInfo productInfo : productInfoList) {
        //          categoryTypeList.add(productInfo.getCategoryType());
        //      }
        //精简方法(JAVA8,lambda)
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //3.数据拼装

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
     return  ResultVOUtil.success(productVOList);

    }
}
