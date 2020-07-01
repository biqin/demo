package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.UserPlus;
import com.example.demo.mapper.UserMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserPlusService {
    @Autowired
    private UserMapperPlus userMapperPlus;

    public UserPlus getUserById(int id) {
        return userMapperPlus.selectById(id);
    }

    public void addUser(UserPlus user) {
        userMapperPlus.insert(user);
    }

    public List<UserPlus> getUsersByIds(List<Integer> ids) {
        return userMapperPlus.selectByIds(ids);
    }

    public UserPlus getUserByName(String userName) {
        return userMapperPlus.selectByUsername(userName);
    }

    public void deleteUserById(int id) {
        userMapperPlus.deleteById(id);
    }

    public IPage<UserPlus> getUsersPageByCreateTime(IPage<UserPlus> page, Date createTime) {
        return userMapperPlus.selectPageByCreateTime(page, createTime);
    }
}
