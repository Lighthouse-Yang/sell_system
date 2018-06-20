package com.mooc.dataobject;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yangbo
 * 2018-06-13 15:38
 */
@Entity
@Data
public class SellerInfo {

    @Id
    /**id.*/
    private String sellerId;

    /**用户名称.*/
    private String userName;

    /**密码.*/
    private String password;

    /**微信ID.*/
    private String openId;

    /**创建时间.*/
    private Date createTime;

    /**更新时间.*/
    private Date updateTime;

}
