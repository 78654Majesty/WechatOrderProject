package com.kobe.wxorder.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 订单表
 * @author fanglingxiao
 * @date 2019/6/3
 */
@Entity
@DynamicUpdate
@Data
public class Order {
    /** 订单号 */
    @Id
    private String orderId;
    /** 买家名 */
    private String buyerName;
    /** 买家手机号 */
    private String buyerPhone;
    /** 买家地址 */
    private String buyerAddress;
    /** 微信号 */
    private String buyerOpenid;
    /** 订单价格 */
    private Double orderAmount;
    /** 订单状态 */
    private Integer orderStatus;
    /** 支付状态 */
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;
}
