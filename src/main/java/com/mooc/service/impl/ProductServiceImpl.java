package com.mooc.service.impl;

import com.mooc.dataobject.ProductInfo;
import com.mooc.dto.CartDTO;
import com.mooc.enums.ProductStatusEnum;
import com.mooc.enums.ResultEnum;
import com.mooc.exception.SellException;
import com.mooc.repository.ProductInfoRepository;
import com.mooc.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
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

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional   //事务操作---异常回滚
    /**减库存
     *for循环变量遍历
     * 利用findOne(cartDTO.getProductID)查询商品是否存在,不存在抛出异常.
     * 存在则进行下一步.
     */
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductID());
            if (productInfo == null) {
            //商品不存在,则抛出异常.
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }
}
