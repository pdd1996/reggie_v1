package com.reggie.employee.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reggie.employee.domain.entity.Employee;
import com.reggie.employee.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private EmployeeMapper employeeMapper;

    public Page<Employee> getEmployeeList(Page<Employee> employeePage) {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        return employeeMapper.selectPage(employeePage, lambdaQueryWrapper);
    }
}
