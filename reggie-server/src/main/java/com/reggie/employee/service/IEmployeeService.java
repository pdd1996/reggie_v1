package com.reggie.employee.service;

import cn.dev33.satoken.util.SaResult;
import com.reggie.employee.domain.dto.EmployeeLoginDto;

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
}
