package com.kobe.wxorder.service;

import com.kobe.wxorder.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    /** */
    OrderDetail findById(String detailId);

    /** */
    List<OrderDetail> findByOrderId(String orderId);

    /** */
    List<OrderDetail> findAll();

    void save(OrderDetail orderDetail);
}
