package com.kobe.wxorder.service.impl;

import com.kobe.wxorder.dao.OrderMasterDao;
import com.kobe.wxorder.model.OrderMaster;
import com.kobe.wxorder.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/6/4
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    public OrderMaster findByOrderId(String orderId) {
        return orderMasterDao.getOne(orderId);
    }

    @Override
    public List<OrderMaster> findByBuyerOpenid(String buyerOpenid) {
        return orderMasterDao.findByBuyerOpenid(buyerOpenid);
    }

    @Override
    public List<OrderMaster> findAll() {
        return orderMasterDao.findAll();
    }

    @Override
    public Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable) {
        return orderMasterDao.findByBuyerOpenid(buyerOpenid, pageable);
    }
}
