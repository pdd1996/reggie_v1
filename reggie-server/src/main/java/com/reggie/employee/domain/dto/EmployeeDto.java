package com.reggie.employee.domain.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;

    private String name;

    private String username;

    private String phone;

    private Integer status;

}
