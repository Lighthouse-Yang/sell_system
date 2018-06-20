package com.mooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yangbo
 * 2018-06-13 15:29
 */
@Entity
@Data
public class OrderMaster {

    @Id
    /**订单id.*/
    private String orderId;

    /**买家姓名.*/
    private String buyerName;

    /**买家电话.*/
    private String buyerPhone;

    /**买家地址.*/
    private String buyerAddress;

    /**买家微信ID.*/
    private String buyerOpenid;

    /**订单价格.*/
    private BigDecimal orderAmount;

    /**订单状态-默认0新订单.*/
    private Integer orderStatus;

    /**支付状态-默认0新订单.*/
    private Integer payStatus;

    /**创建时间.*/
    private Date createTime;

    /**更新时间.*/
    private Date updateTime;
}
