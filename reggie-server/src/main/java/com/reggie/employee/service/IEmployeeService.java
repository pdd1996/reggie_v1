package com.reggie.employee.service;

import cn.dev33.satoken.util.SaResult;
import com.reggie.common.domain.resp.ApiResult;
import com.reggie.common.domain.resp.PageResponse;
import com.reggie.employee.domain.dto.EmployeeDto;
import com.reggie.employee.domain.dto.EmployeeLoginDto;
import com.reggie.employee.domain.dto.InsertEmployeeDto;
import com.reggie.employee.domain.entity.Employee;

/**
 * <p>
 * 员工信息 服务类
 * </p>
 *
 * @author paddy
 * @since 2024-08-04
 */
public interface IEmployeeService {

    SaResult login(EmployeeLoginDto employeeLoginDto);

    SaResult logout();

    ApiResult<Employee> save(InsertEmployeeDto insertEmployeeDto);

    PageResponse<EmployeeDto> getEmployeeList(Integer page, Integer pageSize);
}
