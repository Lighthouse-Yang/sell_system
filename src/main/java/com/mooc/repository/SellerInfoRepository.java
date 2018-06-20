package com.mooc.repository;

import com.mooc.dataobject.ProductInfo;
import com.mooc.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yangbo
 * 2018-06-13 16:02
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    List<SellerInfo> findBysellerId(String sellerId);

}
