package com.mooc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mooc.dataobject.OrderDetail;
import com.mooc.enums.OrderStatusEnum;
import com.mooc.enums.PayStatusEnum;
import com.mooc.utils.EnumUtil;
import com.mooc.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.apache.commons.lang3.EnumUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author yangbo
 * 2018-06-22 16:34
 */
@Data
public class OrderDTO {

    /**订单id.*/
    private String orderId;

    /**买家姓名.*/
    private String buyerName;

    /**买家手机号.*/
    private String buyerPhone;

    /**买家地址.*/
    private String buyerAddress;

    /**买家微信Openid.*/
    private String buyerOpenid;

    /**订单总金额.*/
    private BigDecimal orderAmount;

    /**订单状态-默认0新订单.*/
    private Integer orderStatus;

    /**支付状态-默认0未支付.*/
    private Integer payStatus;

    /**创建时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)//本来是毫秒级的，转换成秒级
    private Date createTime;

    /**更新时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)//本来是毫秒级的，转换成秒级
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

}

