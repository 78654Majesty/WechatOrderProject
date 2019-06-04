package com.kobe.wxorder.service;

import com.kobe.wxorder.model.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    /** */
    ProductInfo findById(String productId);

    /** */
    List<ProductInfo> findAll();
}
