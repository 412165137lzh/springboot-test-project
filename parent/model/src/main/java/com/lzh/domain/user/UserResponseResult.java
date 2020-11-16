package com.lzh.domain.user;

import com.lzh.domain.base.QueryResponseResult;
import com.lzh.domain.base.ResultCode;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserResponseResult extends QueryResponseResult<User> {

    public UserResponseResult(){
        super();
    }

    public UserResponseResult(ResultCode resultCode, List<User> list, long total) {
        super(resultCode, list, total);
    }

    public UserResponseResult(ResultCode resultCode) {
        super(resultCode);
    }
}
