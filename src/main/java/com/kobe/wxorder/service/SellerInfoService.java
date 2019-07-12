package com.kobe.wxorder.service;

import com.kobe.wxorder.model.SellerInfo;

import java.util.List;

public interface SellerInfoService {
    /** */
    SellerInfo findById(Integer id);

    /** */
    SellerInfo findByOpenid(String openId);

    /** */
    List<SellerInfo> findAll();
}
