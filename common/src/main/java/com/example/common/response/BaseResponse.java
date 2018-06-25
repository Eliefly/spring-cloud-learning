package com.example.common.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -6649395486734298770L;
    protected boolean success = false;
    protected String msg;
    protected String errorCode;

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}