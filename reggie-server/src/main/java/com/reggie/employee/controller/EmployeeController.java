package com.reggie.employee.controller;


import cn.dev33.satoken.util.SaResult;
import com.reggie.employee.domain.entity.Employee;
import com.reggie.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 员工信息 前端控制器
 * </p>
 *
 * @author paddy
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @PostMapping("/login")
    public SaResult login(@RequestBody Employee employee) {
        System.out.println("login" + employee);
        return employeeService.login(employee);
    }
}

