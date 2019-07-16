package com.kobe.wxorder.dto;

import com.kobe.wxorder.model.OrderDetail;
import lombok.Data;

import java.util.List;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/16
 */
@Data
public class OrderDTO {
    /**
     * 买家姓名
     */
    private String name;

    /**
     * 买家手机号
     */
    private String phone;

    /**
     * 买家地址
     */
    private String address;

    /**
     * 买家微信openid
     */
    private String openid;

    List<OrderDetail> orderDetailList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
