package com.kobe.wxorder.dao;

import com.kobe.wxorder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanglingxiao
 * @date 2019/6/3
 */
public interface OrderDao extends JpaRepository<Order,String> {
}
