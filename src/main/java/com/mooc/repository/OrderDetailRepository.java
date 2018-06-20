package com.mooc.repository;

import com.mooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author yangbo
 * 2018-06-13 16:01
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);

}
