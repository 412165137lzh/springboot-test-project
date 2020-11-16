package com.lzh.domain.user;

import com.lzh.domain.base.ResponseResult;
import com.lzh.domain.base.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserResult extends ResponseResult<User> {

    public UserResult(){
        super();
    }

    public UserResult(ResultCode resultCode) {
        super(resultCode);
    }

    public UserResult(ResultCode resultCode, User javaBean) {
        super(resultCode, javaBean);
    }
}
