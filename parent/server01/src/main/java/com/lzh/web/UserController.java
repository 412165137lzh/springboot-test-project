package com.lzh.web;

import com.lzh.domain.base.CommonCode;
import com.lzh.domain.user.User;
import com.lzh.domain.user.UserResponseResult;
import com.lzh.domain.user.UserResult;
import com.lzh.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public UserResult getUserById(@PathVariable String id){
        int i = 1/0;
        User user = userService.getUserById(id);
        UserResult userResult = new UserResult(CommonCode.SUCCESS, user);
        return userResult;
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public UserResponseResult getAllUser(String index, String page){
        List<User> users = userService.getAllUser();
        UserResponseResult userResponseResult = new UserResponseResult(CommonCode.SUCCESS, users, users.size());
        return userResponseResult;
    }

    @RequestMapping("getAllName")
    @ResponseBody
    public UserResponseResult getAllName(){
        List<User> users = userService.getAllName();
        UserResponseResult userResponseResult = new UserResponseResult(CommonCode.SUCCESS, users, users.size());
        return userResponseResult;
    }

}
