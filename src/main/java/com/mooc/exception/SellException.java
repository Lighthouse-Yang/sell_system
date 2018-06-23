package com.mooc.exception;

import com.mooc.enums.ResultEnum;

/**
 * @author yangbo
 * 2018-06-23 21:14
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();

    }
}
