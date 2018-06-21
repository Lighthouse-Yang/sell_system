package com.mooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 * @author yangbo
 * @date 2018-06-10 16:07
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /**商品id.*/   //随机产生的字符
    @Id          //主键
    private String productId;

    /**商品名称.*/
    private String productName;

    /**商品价格.*/
    private BigDecimal productPrice;

    /**商品库存.*/
    private Integer productStock;

    /**商品描述.*/
    private String productDescription;

    /**商品小图.*/
    private String productIcon;

    /**商品状态.0正常1下架*/
    private Integer productStatus;

    /**类目编号.*/
    private Integer categoryType;

    /**创建时间.*/
    private Date createTime;

    /**更新时间.*/
    private Date updateTime;

}
