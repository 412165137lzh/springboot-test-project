package com.lzh.domain.base;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseResult<T> {

    //操作是否成功
    private boolean success ;
    //操作代码
    private int code ;
    //提示信息
    private String message;
    private T data;

    public ResponseResult(){super();};

    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();

    }

    public ResponseResult(ResultCode resultCode,T data){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

}
