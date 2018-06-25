package com.mooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**订单详情表
 * @author yangbo
 * 2018-06-13 15:02
 */
@Entity
@Data
public class OrderDetail {

    @Id
    /**类目id.*/
    private String detailId;

    /**订单id.*/
    private String orderId;

    /**商品id.*/
    private String productId;

    /**商品名称.*/
    private String productName;

    /**商品单价.*/
    private BigDecimal productPrice;

    /**商品数量.*/
    private Integer productQuantity;

    /**商品小图.*/
    private String productIcon;

    /**创建时间.*/
    private Date createTime;

    /**更新时间.*/
    private Date updateTime;
}
