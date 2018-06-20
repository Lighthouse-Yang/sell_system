package com.mooc.VO;

import lombok.Data;

/**
 * http返回请求的最外层格式
 * @author yangbo
 * 2018-06-17 0:34
 */
@Data
public class ResultVO<T> {

    /** 错误码.*/
    private  Integer code;

    /** 提示信息.*/
    private String msg;

    /**因为data内部是一个对象,所以data类型的选择为泛型*/
    /** 具体内容.*/
    private T data;
}
