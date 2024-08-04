package com.reggie.employee.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.reggie.common.exception.BusinessException;
import com.reggie.common.exception.UserExceptionEnum;
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
            throw new BusinessException(UserExceptionEnum.USER_IS_NOT_EXIST);
        }
        String password = employeeLoginDto.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!password.equals(user.getPassword())) {
            throw new BusinessException(UserExceptionEnum.USER_PASSWORD_ERROR);
        }
        StpUtil.login(user.getId());
        return SaResult.ok(StpUtil.getTokenInfo().getTokenValue());
    }
}
