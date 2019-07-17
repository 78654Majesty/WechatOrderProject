package com.kobe.wxorder.exception;

import com.kobe.wxorder.enums.ResponseError;

/**
 * description
 * 订单异常类
 * @author fanglingxiao
 * @date 2019/7/17
 */
public class SellException extends RuntimeException {

    private int code;

    public SellException(ResponseError responseError) {
        super(responseError.getMessage());

        this.code = responseError.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
