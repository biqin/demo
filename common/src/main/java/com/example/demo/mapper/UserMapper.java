package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper {

    public User queryUserById(int id);

    @Insert("insert into tb_user values(#{id}, #{userName}, #{password}, #{name}, #{age}, #{sex}, #{birthday}, #{created}, #{updated})")
    public void insert(User user);
}