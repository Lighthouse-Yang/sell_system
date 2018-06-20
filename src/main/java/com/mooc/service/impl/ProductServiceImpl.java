package com.mooc.service.impl;

import com.mooc.dataobject.ProductInfo;
import com.mooc.enums.ProductStatusEnum;
import com.mooc.repository.ProductInfoRepository;
import com.mooc.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * @author yangbo
 * 2018-06-14 10:55
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override   //查询在架商品
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override   //查询下架商品
    public List<ProductInfo> findDownAll() {
        return repository.findByProductStatus(ProductStatusEnum.DOWN.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
