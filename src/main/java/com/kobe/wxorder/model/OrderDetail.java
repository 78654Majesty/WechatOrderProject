package com.kobe.wxorder.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 订单详情表
 * @author fanglingxiao
 * @date 2019/6/3
 */
@Entity
@DynamicUpdate
@Data
public class OrderDetail {
    /** 订单详情号 */
    @Id
    private String detailId;
    /** 订单号 */
    private String orderId;
    /** 商品号 */
    private String productId;
    /** 商品名称 */
    private String productName;
    /** 商品价格 */
    private Double productPrice;
    /** 商品数量 */
    private String productQuantity;
    /** 商品小图 */
    private String productIcon;
    private Date createTime;
    private Date updateTime;
}
