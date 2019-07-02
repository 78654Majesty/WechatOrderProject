package com.kobe.wxorder.vo;

/**
 * @author fanglingxiao
 * @date 2019/6/30
 */
public class OrderListParamVo {
    private String openid;
    private int pageSize;
    private int pageNumber;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
