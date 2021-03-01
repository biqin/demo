package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserPlus;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;

@Api("用户信息")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("获取用户")
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return new User();
        //return userService.getUser(id);
    }

    @ApiOperation("获取用户")
    @RequestMapping(value="{id}/async", method=RequestMethod.GET)
    public DeferredResult<User> getUserAsync(@PathVariable int id) {
        DeferredResult<User> deferredResult = new DeferredResult<>();
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("haha");
            deferredResult.setResult(userService.getUser(id));
        }).start();
        return deferredResult;
    }

    @ApiOperation("添加用户")
    @RequestMapping(method=RequestMethod.POST)
    public boolean addUser(User user) {
        userService.addUser(user);
        return true;
    }
}