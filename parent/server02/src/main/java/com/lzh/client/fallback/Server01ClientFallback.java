package com.lzh.client.fallback;

import com.lzh.client.Server01Client;
import com.lzh.domain.base.CommonCode;
import com.lzh.domain.user.UserResponseResult;
import com.lzh.domain.user.UserResult;
import org.springframework.stereotype.Component;

@Component
public class Server01ClientFallback implements Server01Client {

    @Override
    public UserResult getUserById(String id) {
        return new UserResult(CommonCode.FAIL_TIMEOUT);
    }

    @Override
    public UserResponseResult getAllUser() {
        return new UserResponseResult(CommonCode.FAIL_TIMEOUT);
    }
}
