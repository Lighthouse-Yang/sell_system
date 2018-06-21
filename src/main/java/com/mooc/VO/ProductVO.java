package com.mooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)-----第二层
 * @author yangbo
 * 2018-06-18 23:17
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    /*
    * 前端名称为name，但是不明确所以后端改为categoryName
    * 但是需要前端显示name，所以用注解@JsonProperty("name")
    * 这样前端是name，后端是categoryName
     */
    /** 类目名称.*/
    private String categoryName;

    @JsonProperty("type")
    /** 类目编号.*/
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
