package com.kobe.wxorder.service.impl;

import com.kobe.wxorder.dao.OrderDetailDao;
import com.kobe.wxorder.model.OrderDetail;
import com.kobe.wxorder.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/12
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public OrderDetail findById(String detailId) {
        return orderDetailDao.getOne(detailId);
    }

    @Override
    public List<OrderDetail> findByOrderId(String orderId) {
        return orderDetailDao.findByOrderId(orderId);
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailDao.findAll();
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailDao.save(orderDetail);
    }
}
