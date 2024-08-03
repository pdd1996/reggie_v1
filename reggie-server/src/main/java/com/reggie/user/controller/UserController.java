package com.reggie.user.controller;


import com.reggie.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author paddy
 * @since 2024-08-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/test")
    public String getUser() {
        return userService.getUserById(1).getName();
    }
}

