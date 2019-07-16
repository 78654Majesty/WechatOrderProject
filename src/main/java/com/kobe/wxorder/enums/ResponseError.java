package com.kobe.wxorder.enums;

public enum ResponseError {
    /**
     * response错误码
     */
    PARAMS_REEOR(-100,"参数错误");

    private int code;

    private String message;

    ResponseError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
