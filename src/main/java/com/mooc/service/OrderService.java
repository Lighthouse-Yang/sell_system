package com.mooc.service;

import com.mooc.dataobject.OrderDetail;

import java.util.List;

/**
 * @author yangbo
 * 2018-06-17 0:12
 */
public interface OrderService {

    OrderDetail findOne(String orderId);

    List<OrderDetail> findAll();


}
