package com.kobe.wxorder.service;

import com.kobe.wxorder.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    /** */
    OrderDetail findById(String detailId);

    /** */
    OrderDetail findByOrderId(String orderId);

    /** */
    List<OrderDetail> findAll();
}
