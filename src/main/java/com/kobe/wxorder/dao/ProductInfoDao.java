package com.kobe.wxorder.dao;

import com.kobe.wxorder.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author fanglingxiao
 * @createTime 2019/6/3
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
//    List<ProductInfo> findByProductStatus();
}
