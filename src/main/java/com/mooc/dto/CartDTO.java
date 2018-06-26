package com.mooc.dto;

import lombok.Data;

/**购物车
 * @author yangbo
 * 2018-06-25 15:02
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private String productID;

    /** 数量. */
    private Integer productQuantity;


    public CartDTO(String productID, Integer productQuantity) {
        this.productID = productID;
        this.productQuantity = productQuantity;
    }
}
