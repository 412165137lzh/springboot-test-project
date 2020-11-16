package com.lzh.domain.base;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class QueryResponseResult<T> {

    //操作是否成功
    private boolean success;
    //操作代码
    private int code;
    //提示信息
    private String message;
    //数据列表
    private List<T> list;
    //数据总数
    private long total;

    public QueryResponseResult(){
        super();
    }

    public QueryResponseResult(ResultCode resultCode, List<T> list,long total) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.list = list;
        this.total = total;
    }

    public QueryResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }
}
