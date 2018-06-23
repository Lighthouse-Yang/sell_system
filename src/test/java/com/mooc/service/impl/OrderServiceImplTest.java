package com.mooc.service.impl;

import com.mooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yangbo
 * 2018-06-22 16:06
 */
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void findOne() throws Exception {


    }

    @Test
    public void findAll() {

        List<OrderDetail> orderDetailList = orderService.findAll();
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}