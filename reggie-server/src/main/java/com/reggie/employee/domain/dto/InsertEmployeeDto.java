package com.reggie.employee.domain.dto;

import lombok.Data;

@Data
public class InsertEmployeeDto {

    private Long id;

    private String username;

    private String password;

    private String idNumber;

    private String name;

    private String phone;

    private Integer status;

    private String sex;
}
