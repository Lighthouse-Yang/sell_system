package com.mooc.dataobject;

import com.mooc.enums.OrderStatusEnum;
import com.mooc.enums.PayStatusEnum;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**订单买家情况表
 * @author yangbo
 * 2018-06-13 15:29
 */
@Entity
@Data
@DynamicUpdate       //时间字段自动更新.
public class OrderMaster {

    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**支付状态-默认0未支付.*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**创建时间.*/
    private Date createTime;

    /**更新时间.*/
    private Date updateTime;
}
