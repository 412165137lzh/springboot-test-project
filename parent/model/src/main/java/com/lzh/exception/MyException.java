package com.lzh.exception;

import com.lzh.domain.base.ResultCode;

public class MyException extends Exception {

    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public MyException() {
    }

    public MyException(String error_message) {
        super(error_message);
    }

    public MyException(ResultCode resultCode) {
        super(resultCode.message());
        this.resultCode = resultCode;
    }
}
