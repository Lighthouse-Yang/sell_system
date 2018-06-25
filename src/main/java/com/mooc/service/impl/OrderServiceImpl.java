package com.mooc.service.impl;

import com.mooc.dataobject.OrderDetail;
import com.mooc.dataobject.OrderMaster;
import com.mooc.dataobject.ProductInfo;
import com.mooc.dto.OrderDTO;
import com.mooc.enums.ResultEnum;
import com.mooc.exception.SellException;
import com.mooc.repository.OrderDetailRepository;
import com.mooc.repository.SellerInfoRepository;
import com.mooc.service.OrderService;
import com.mooc.service.ProductService;
import com.mooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

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
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private pay

    @Override
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


            //3. 订单详情入库
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




        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
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
