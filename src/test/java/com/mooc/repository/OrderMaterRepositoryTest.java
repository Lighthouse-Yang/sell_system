package com.mooc.repository;

import com.mooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author yangbo
 * 2018-06-21 23:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMaterRepositoryTest {

    @Autowired
    private OrderMaterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("大傻子");
        orderMaster.setBuyerAddress("大傻子的家里");
        orderMaster.setBuyerOpenid("WODEWEIXIN");
        orderMaster.setBuyerPhone("88888888888");
        orderMaster.setOrderAmount(new BigDecimal(100));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {

    }
}