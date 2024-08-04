package com.reggie.employee.dao;

import com.reggie.employee.domain.entity.Employee;
import com.reggie.employee.mapper.EmployeeMapper;
import com.reggie.employee.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author paddy
 * @since 2024-08-04
 */
@Service
public class EmployeeDao extends ServiceImpl<EmployeeMapper, Employee> {

}
