package com.mooc.utils;

import com.mooc.enums.CodeEnum;

/**
 * @author yangbo
 * 2018-06-23 14:54
 */
public class EnumUtil {

    public static  <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass) {
        for (T each:enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
