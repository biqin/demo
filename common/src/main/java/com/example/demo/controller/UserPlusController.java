package com.example.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.entity.UserPlus;
import com.example.demo.service.UserPlusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api("用户Plus信息")
@RestController
@RequestMapping("/userpluses")
public class UserPlusController {
    @Autowired
    private UserPlusService userPlusService;

    @ApiOperation("获取用户")
    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public UserPlus getUser(@PathVariable int id) {
        return userPlusService.getUserById(id);
    }

    @ApiOperation("获取用户列表")
    @RequestMapping(value="batch", method=RequestMethod.POST)
    public List<UserPlus> getUsers(@RequestBody List<Integer> ids) {
        return userPlusService.getUsersByIds(ids);
    }

    @ApiOperation("添加用户")
    @RequestMapping(method=RequestMethod.POST)
    public boolean addUser(@RequestBody UserPlus user) {
        userPlusService.addUser(user);
        return true;
    }

    @ApiOperation("删除用户")
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public boolean delUser(@PathVariable int id) {
        userPlusService.deleteUserById(id);
        return true;
}

    @ApiOperation("获取所有用户")
    @RequestMapping(method=RequestMethod.GET)
    public IPage<UserPlus> getUsersByCreateTime(int pageNo, int pageSize, Date createTime) {
        IPage<UserPlus> page = new Page<>(pageNo, pageSize);
        return userPlusService.getUsersPageByCreateTime(page, createTime);
    }

}
