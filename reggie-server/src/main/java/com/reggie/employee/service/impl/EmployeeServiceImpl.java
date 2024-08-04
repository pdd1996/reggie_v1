package com.reggie.employee.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.reggie.employee.dao.EmployeeDao;
import com.reggie.employee.domain.dto.EmployeeLoginDto;
import com.reggie.employee.domain.entity.Employee;
import com.reggie.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public SaResult login(EmployeeLoginDto employeeLoginDto) {
        Employee user = employeeDao.lambdaQuery().eq(Employee::getUsername, employeeLoginDto.getUsername()).one();
        if (user == null) {
            return SaResult.error("用户不存在");
        }
        String password = employeeLoginDto.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(password.equals(user.getPassword())) {
            StpUtil.login(10001);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }
}
