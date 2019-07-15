package com.kobe.wxorder.service;

import com.kobe.wxorder.model.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderMasterService {
    /** */
    OrderMaster findByOrderId(String orderId);

    /** */
    List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

    /** */
    List<OrderMaster> findAll();

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
