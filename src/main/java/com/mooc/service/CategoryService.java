package com.mooc.service;

import com.mooc.dataobject.ProductCategory;
import java.util.List;

/**
 * 类目
 * @author yangbo
 * @date 2018-06-10 13:23
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();   //查询所有类目

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
