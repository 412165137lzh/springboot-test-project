package com.lzh.dao;

import com.lzh.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

    @Query(value = "select new User(name) from User")
//    @Query(value = "select id from user",nativeQuery=true)
//    @Query(value = "select age,id from user",nativeQuery=true)
    public List<User> getAllName();
}
