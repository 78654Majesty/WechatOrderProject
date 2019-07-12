package com.kobe.wxorder.dao;

import com.kobe.wxorder.model.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author fanglingxiao
 * @date 2019/6/3
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
