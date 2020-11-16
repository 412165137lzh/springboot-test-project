package com.lzh.sevice;


import com.lzh.dao.UserRepository;
import com.lzh.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(String id){
        Optional<User> option = userRepository.findById(id);
        User user = null;
        if (option.isPresent()){
            user = option.get();
        }
        return user;
    }

    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<User> getAllName() {
        List<User> users = userRepository.getAllName();
        return users;
    }
}
