package com.kobe.wxorder.service;

import com.kobe.wxorder.model.OrderMaster;

import java.util.List;

public interface OrderMasterService {
    /** */
    OrderMaster findByOrderId(String orderId);

    /** */
    List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

    /** */
    List<OrderMaster> findAll();
}
