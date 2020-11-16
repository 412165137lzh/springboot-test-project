package com.lzh.domain.base;

public class CommonCode implements ResultCode {
    public static CommonCode SUCCESS = new CommonCode(true,10000,"请求成功");
    public static CommonCode FAIL = new CommonCode(false,20000,"系统异常，请稍后再试");
    public static CommonCode FAIL_TIMEOUT = new CommonCode(false,30000,"feign调用超时，请稍后再试");
    public static CommonCode FAIL_SUBMIT = new CommonCode(false,20001,"前面的流程未完成，无法提交");

    private boolean success;
    private int code;
    private String message;

    public CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }
    @Override
    public String message() {
        return message;
    }
}
