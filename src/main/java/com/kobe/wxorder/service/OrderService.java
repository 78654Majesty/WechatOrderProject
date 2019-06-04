package com.kobe.wxorder.service;

import com.kobe.wxorder.model.Order;

import java.util.List;

public interface OrderService {
    /** */
    Order findById(String orderId);

    /** */
    Order findByOpenId(String openId);

    /** */
    List<Order> findAll();
}
