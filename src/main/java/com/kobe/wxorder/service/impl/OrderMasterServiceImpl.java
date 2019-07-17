package com.kobe.wxorder.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.kobe.wxorder.dao.OrderMasterDao;
import com.kobe.wxorder.dto.OrderDTO;
import com.kobe.wxorder.enums.ResponseError;
import com.kobe.wxorder.exception.SellException;
import com.kobe.wxorder.model.OrderDetail;
import com.kobe.wxorder.model.OrderMaster;
import com.kobe.wxorder.model.ProductInfo;
import com.kobe.wxorder.service.OrderDetailService;
import com.kobe.wxorder.service.OrderMasterService;
import com.kobe.wxorder.service.ProductInfoService;
import com.kobe.wxorder.utils.KeyUtils;
import com.kobe.wxorder.vo.OrderFormVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ProductInfoService productInfoService;

    private static final Logger logger = LoggerFactory.getLogger(OrderMasterServiceImpl.class);

    /**
     * 通过订单号查询
     * @param orderId orderId
     * @return OrderMaster
     */
    @Override
    public OrderMaster findByOrderId(String orderId) {
        return orderMasterDao.getOne(orderId);
    }

    /**
     * 根据微信号查询
     * @param buyerOpenid buyerOpenid
     * @return List<OrderMaster>
     */
    @Override
    public List<OrderMaster> findByBuyerOpenid(String buyerOpenid) {
        return orderMasterDao.findByBuyerOpenid(buyerOpenid);
    }

    /**
     * 查询所有订单信息
     * @return List<OrderMaster>
     */
    @Override
    public List<OrderMaster> findAll() {
        return orderMasterDao.findAll();
    }

    /**
     * 根据买家微信分页查询订单信息
     * @param buyerOpenid buyerOpenid
     * @param pageable pageable
     * @return Page<OrderMaster>
     */
    @Override
    public Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable) {
        return orderMasterDao.findByBuyerOpenid(buyerOpenid, pageable);
    }

    /**
     * 创建订单
     * @param orderFormVO orderFormVO
     * @return orderId
     */
    @Override
    public String create(OrderFormVO orderFormVO) {
        OrderDTO orderDTO = convert(orderFormVO);
        String orderId = KeyUtils.createUniqueKey();
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        if (!CollectionUtils.isEmpty(orderDetailList)) {
            for (OrderDetail orderDetail : orderDetailList) {
                //获取商品信息
                String productId = orderDetail.getProductId();
                ProductInfo productInfo = productInfoService.findByProductId(productId);
                if (null == productInfo) {
                    logger.info("当前商品不存在！商品id={}", productId);
                    throw new SellException(ResponseError.PRODUCT_NOT_EXIST);
                }
                //计算价格
                int productQuantity = orderDetail.getProductQuantity();
                orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(productQuantity)).add(orderAmount);
                //入库
                orderDetail.setDetailId(KeyUtils.createUniqueKey());
                orderDetail.setOrderId(orderId);
                orderDetail.setProductId(productId);
                orderDetail.setProductName(productInfo.getProductName());
                orderDetail.setProductPrice(productInfo.getProductPrice());
                orderDetail.setProductQuantity(productQuantity);
                orderDetail.setProductIcon(productInfo.getProductIcon());
                orderDetail.setCreateTime(new Date());
                orderDetail.setUpdateTime(new Date());
                orderDetailService.save(orderDetail);
            }
        }
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerName(orderDTO.getName());
        orderMaster.setBuyerPhone(orderDTO.getPhone());
        orderMaster.setBuyerAddress(orderDTO.getAddress());
        orderMaster.setBuyerOpenid(orderDTO.getOpenid());
        orderMaster.setOrderAmount(orderAmount);
        //订单状态 0=新订单 1=完结 2=已取消
        orderMaster.setOrderStatus(0);
        //支付状态 0=未支付 1=支付成功 2=支付失败
        orderMaster.setPayStatus(0);
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        orderMasterDao.save(orderMaster);
        return orderId;
    }

    private OrderDTO convert(OrderFormVO orderFormVO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setName(orderFormVO.getName());
        orderDTO.setPhone(orderFormVO.getPhone());
        orderDTO.setAddress(orderFormVO.getAddress());
        orderDTO.setOpenid(orderFormVO.getOpenid());
        List<OrderDetail> detailList = JSONObject.parseObject(orderFormVO.getItems(), new TypeReference<List<OrderDetail>>() {
        });
        orderDTO.setOrderDetailList(detailList);
        return orderDTO;
    }
}
