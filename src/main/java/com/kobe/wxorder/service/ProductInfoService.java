package com.kobe.wxorder.service;

import com.kobe.wxorder.model.OrderDetail;
import com.kobe.wxorder.model.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    /** */
    ProductInfo findByProductId(String productId);

    /** */
    List<ProductInfo> findAll();

    /** 扣减商品库存 */
    void decreaseStock(List<OrderDetail> orderDetailList);
}
