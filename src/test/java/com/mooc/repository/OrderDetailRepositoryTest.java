package com.mooc.repository;

import com.mooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yangbo
 * 2018-06-22 10:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("xxxxxxxxxxxxxxx");
        orderDetail.setProductName("大龙虾");
        orderDetail.setProductId("123432");
        orderDetail.setProductPrice(new BigDecimal(888));
        orderDetail.setProductQuantity(4);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}