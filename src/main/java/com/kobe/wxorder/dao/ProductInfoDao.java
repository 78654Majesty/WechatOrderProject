package com.kobe.wxorder.dao;

import com.kobe.wxorder.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanglingxiao
 * @createTime 2019/6/3
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
}
