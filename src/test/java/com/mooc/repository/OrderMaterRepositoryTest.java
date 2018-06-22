package com.mooc.repository;

import com.mooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private final String OPENID = "WODEWEIXIN";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456666");
        orderMaster.setBuyerName("大傻子");
        orderMaster.setBuyerAddress("大傻子的家里");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("88888888888");
        orderMaster.setOrderAmount(new BigDecimal(100));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        //page为页数，从第0页开始.  size为每一页的数量.
        PageRequest request = new PageRequest(1,1);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);
        System.out.println(result.getTotalElements());

    }

    }
