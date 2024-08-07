package com.reggie.employee.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reggie.common.domain.resp.PageResponse;
import com.reggie.common.exception.BusinessException;
import com.reggie.common.exception.UserExceptionEnum;
import com.reggie.employee.dao.EmployeeDao;
import com.reggie.employee.domain.dto.EmployeeDto;
import com.reggie.employee.domain.dto.EmployeeLoginDto;
import com.reggie.employee.domain.dto.InsertEmployeeDto;
import com.reggie.employee.domain.entity.Employee;
import com.reggie.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String token = StpUtil.getTokenInfo().getTokenValue();
        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        result.put("username", user.getUsername());
        result.put("name", user.getName());
        return SaResult.data(result);
    }

    @Override
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @Override
    public String save(InsertEmployeeDto insertEmployeeDto) {

        return "";
    }

    @Override
    public PageResponse<EmployeeDto> getEmployeeList(Integer page, Integer pageSize) {
        Page<Employee> employeePage = new Page<>(page, pageSize);
        Page<Employee> allEmployee = employeeDao.getEmployeeList(employeePage);
        List<EmployeeDto> employeeList = new ArrayList<>();
        for (Employee employee: allEmployee.getRecords()) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setPhone(employee.getPhone());
            employeeDto.setStatus(employee.getStatus());
            employeeDto.setUsername(employee.getUsername());
            employeeList.add(employeeDto);
        }
        System.out.println(employeeList);
        PageResponse<EmployeeDto> response = new PageResponse<>();
        response.setRecords(employeeList);
        response.setTotal(employeePage.getTotal());
        response.setPage(page);
        response.setPageSize(pageSize);
        return response;
    }
}
