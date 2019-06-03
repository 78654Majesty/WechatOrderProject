package com.kobe.wxorder.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商家信息
 * @author fanglingxiao
 * @date 2019/6/3
 */
@Entity
@DynamicUpdate
@Data
public class SellerInfo {

    @Id
    @GeneratedValue
    private Integer id;
    /** 商家店名 */
    private String storeName;
    /** 商家账户名 */
    private String sellerName;
    /** 商家密码 */
    private String sellerPassword;
    /** 商家微信 */
    private String sellerOpenid;
    private Date createTime;
    private Date updateTime;

}
