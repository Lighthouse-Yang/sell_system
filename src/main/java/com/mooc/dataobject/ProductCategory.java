package com.mooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目表
 * @author yangbo
 * @date 2018-06-07 22:55
 */
@Entity      //将数据库映射为对象
@DynamicInsert     //动态更新
@Data   //有了@Data 就不需要set、get方法，代码会变简洁一些
public class ProductCategory {

    /**类目id.*/
    @Id    //因为categoryId是主键
    @GeneratedValue   //递增类型
    private Integer categoryId;

    /**类目name.*/
    private String categoryName;

    /**类目编号.*/
    private Integer categoryType;

    public ProductCategory() {}

    /**创建时间.*/
    private Date createTime;

    /**更新时间.*/
    private Date updateTime;

    /**构造方法.*/
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
