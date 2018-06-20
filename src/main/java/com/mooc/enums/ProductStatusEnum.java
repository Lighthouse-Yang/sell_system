package com.mooc.enums;

import lombok.Getter;

/**枚举
 * 商品状态
 * @author yangbo
 * 2018-06-14 11:22
 */
@Getter               //lombok插件
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
