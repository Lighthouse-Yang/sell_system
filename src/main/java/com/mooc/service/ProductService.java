package com.mooc.service;

import com.mooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**商品
 * @author yangbo
 * 2018-06-14 10:35
 */
public interface ProductService {

        ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表、下架商品列表
     * 与按照商品状态查询效果一样，0正常1下架
     * 功能说明：查出下架商品可以再次上架
     * @return
     */
        List<ProductInfo> findUpAll();

        List<ProductInfo> findDownAll();

        //因为存在分页pageable
        Page<ProductInfo> findAll(Pageable pageable);

        ProductInfo save(ProductInfo productInfo);

        //加库存

        //减库存
}
