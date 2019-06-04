package com.kobe.wxorder.service.impl;

import com.kobe.wxorder.dao.OrderDao;
import com.kobe.wxorder.model.Order;
import com.kobe.wxorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/6/4
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order findById(String orderId) {
        return orderDao.getOne(orderId);
    }

    @Override
    public Order findByOpenId(String openId) {
        return orderDao.findByOpenId();
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
