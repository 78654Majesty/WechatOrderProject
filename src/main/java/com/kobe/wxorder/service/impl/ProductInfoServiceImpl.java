package com.kobe.wxorder.service.impl;

import com.kobe.wxorder.dao.ProductInfoDao;
import com.kobe.wxorder.model.ProductInfo;
import com.kobe.wxorder.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/11
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

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
}
