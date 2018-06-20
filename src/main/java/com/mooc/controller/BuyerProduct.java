package com.mooc.controller;

import com.mooc.VO.ProductInfoVO;
import com.mooc.VO.ProductVO;
import com.mooc.VO.ResultVO;
import com.mooc.dataobject.ProductCategory;
import com.mooc.dataobject.ProductInfo;
import com.mooc.service.CategoryService;
import com.mooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 买家商品
 * @author yangbo
 * 2018-06-17 0:27
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProduct {

    @Autowired
    private ProductService productService;

    @Autowired CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {



        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //传统方法
        for (ProductInfo productInfo : productInfoList) {
           // categoryTypeList.add(productInfo.getCategoryType());
        }

        //精简方法(JAVA8)
        //2.查询类目(一次性查询)
        List<Integer> categoryTypeList = new ArrayList<>();
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();
//例子
        productInfoVO.setProductName("小龙虾");
        //productInfoVO.setProductPrice("");
        productInfoVO.setProductDescription("好好吃的哦");
        productInfoVO.setProductIcon("www.xxxxxxxxxx.com");
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));
        resultVO.setCode(0);
        resultVO.setMsg("成功");


        return  resultVO;
    }
}
