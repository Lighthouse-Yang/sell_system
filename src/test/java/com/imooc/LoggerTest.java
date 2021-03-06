package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangbo
 * @date 2018-06-07 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j      //有效的替代了书写--当前类
public class LoggerTest {
                                                          //当前类
    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void test1() {
        String name = "imooc";
        String password = "12345";
        log.debug("debug...");
        log.info("name:" + name +"-----"+ "password:" + password);
        log.info("name: {}, password: {},",name,password);     //更喜欢这种方式
        log.error("error...");
    }
}
