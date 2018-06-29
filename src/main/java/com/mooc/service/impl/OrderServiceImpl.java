package com.mooc.service.impl;

import com.mooc.dataobject.OrderDetail;
import com.mooc.dataobject.OrderMaster;
import com.mooc.dataobject.ProductInfo;
import com.mooc.dto.CartDTO;
import com.mooc.dto.OrderDTO;
import com.mooc.enums.OrderStatusEnum;
import com.mooc.enums.PayStatusEnum;
import com.mooc.enums.ResultEnum;
import com.mooc.exception.SellException;
import com.mooc.repository.OrderDetailRepository;
import com.mooc.repository.OrderMasterRepository;
import com.mooc.service.OrderService;
import com.mooc.service.ProductService;
import com.mooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangbo
 * 2018-06-22 11:53
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional    //事务操作---抛出异常则不进行任何操作，回滚.
    public OrderDTO create(OrderDTO orderDTO) {

        //生成订单id.
        String orderId = KeyUtil.genUniqueKey();

        //定义总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1. 查询商品(数量,价格)
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

        //2. 计算订单总价---->商品表读出商品价格*订单详情表中读出的商品数量——————add相加即可.
        orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);


            //订单详情入库----写入OrderDetail
            /**
             * 订单入库给订单一个随机的订单号.
             * 前端只传入商品单价、商品数量
             * */
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            //将productInfo内容copy到orderDetail.
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
        }


        //3.写入订单数据库(orderMaster和orderDetail)
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);

        orderMasterRepository.save(orderMaster);


        //4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e -> new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;

        //发送webSocket消息
        //webSocket.sendMessage(orderDTO.getOrderId());



    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if (orderMaster == null ) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);


        }


        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
