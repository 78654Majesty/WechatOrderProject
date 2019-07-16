package com.kobe.wxorder.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.kobe.wxorder.dao.OrderMasterDao;
import com.kobe.wxorder.dto.OrderDTO;
import com.kobe.wxorder.model.OrderDetail;
import com.kobe.wxorder.model.OrderMaster;
import com.kobe.wxorder.service.OrderMasterService;
import com.kobe.wxorder.utils.KeyUtils;
import com.kobe.wxorder.vo.OrderFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 * 订单服务
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

    /**
     * 创建订单
     *
     * @param orderFormVO orderFormVO
     * @return orderId
     */
    @Override
    public String create(OrderFormVO orderFormVO) {
        OrderDTO orderDTO = convert(orderFormVO);
        String orderId = KeyUtils.createUniqueKey();

        return null;
    }

    private OrderDTO convert(OrderFormVO orderFormVO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setName(orderFormVO.getName());
        orderDTO.setPhone(orderFormVO.getPhone());
        orderDTO.setAddress(orderFormVO.getAddress());
        orderDTO.setOpenid(orderFormVO.getOpenid());
        List<OrderDetail> detailList = JSONObject.parseObject(orderFormVO.getItems(), new TypeReference<List<OrderDetail>>() {});
        orderDTO.setOrderDetailList(detailList);
        return orderDTO;
    }
}
