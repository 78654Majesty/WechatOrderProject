package com.kobe.wxorder.dao;

import com.kobe.wxorder.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanglingxiao
 * @date  2019/6/3
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
}
