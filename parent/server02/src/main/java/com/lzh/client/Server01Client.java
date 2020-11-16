package com.lzh.client;

import com.lzh.client.fallback.Server01ClientFallback;
import com.lzh.domain.user.UserResponseResult;
import com.lzh.domain.user.UserResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="server01",path = "server01",fallback = Server01ClientFallback.class)
public interface Server01Client {

    @RequestMapping("user/get/{id}")
    public UserResult getUserById(@PathVariable String id);

    @RequestMapping("user/getAllUser")
    public UserResponseResult getAllUser();

    public static void main(String[] args) {
    }

}
