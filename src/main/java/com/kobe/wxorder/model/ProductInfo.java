package com.kobe.wxorder.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品表
 * @author fanglingxiao
 * @date 2019/6/3
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {

    /** 商品编号 */
    @Id
    private String productId;
    /** 商品名 */
    private String productName;
    /** 商品单价 */
    private Double productPrice;
    /** 商品库存 */
    private Integer productStock;
    /** 商品小图 */
    private String productIcon;
    /** 类目编号 */
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
