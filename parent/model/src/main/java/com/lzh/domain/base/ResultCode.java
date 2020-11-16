package com.lzh.domain.base;

public interface ResultCode {
    boolean success();
    int code();
    String message();
}
