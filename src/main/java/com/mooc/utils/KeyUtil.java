package com.mooc.utils;

import java.util.Random;

/**产生随机数--------订单号
 * @author yangbo
 * 2018-06-25 10:13
 */
public class KeyUtil {

    /**
     *生成唯一的主键
     * 格式：时间+随机数
     * @return
     */

    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);



    }


}
