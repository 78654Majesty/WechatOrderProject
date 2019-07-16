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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
