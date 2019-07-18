package com.kobe.wxorder.service.impl;

import com.kobe.wxorder.dao.ProductInfoDao;
import com.kobe.wxorder.enums.ResponseError;
import com.kobe.wxorder.exception.SellException;
import com.kobe.wxorder.model.OrderDetail;
import com.kobe.wxorder.model.ProductInfo;
import com.kobe.wxorder.service.ProductInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * description
 * 商品信息服务
 *
 * @author fanglingxiao
 * @date 2019/7/11
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductInfoServiceImpl.class);

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findByProductId(String productId) {
        return productInfoDao.getOne(productId);
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoDao.findAll();
    }

    @Override
    public void decreaseStock(List<OrderDetail> orderDetailList) {
        if (CollectionUtils.isEmpty(orderDetailList)) {
            logger.info("当前商品信息为空，无法扣减库存！");
            return;
        }
        orderDetailList.forEach(detail -> {
            String productId = detail.getProductId();
            if (StringUtils.isEmpty(productId)) {
                return;
            }
            ProductInfo productInfo = productInfoDao.getOne(productId);
            Integer productStock = productInfo.getProductStock();
            int productQuantity = detail.getProductQuantity();
            if (productStock - productQuantity < 0) {
                throw new SellException(ResponseError.PRODUCT_STOCK_NOT_ENOUGH);
            }
            productInfo.setProductStock(productStock - productQuantity);
            productInfoDao.save(productInfo);
        });
    }
}
