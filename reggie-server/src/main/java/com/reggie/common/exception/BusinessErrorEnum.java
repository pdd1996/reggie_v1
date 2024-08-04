package com.reggie.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  BusinessErrorEnum implements ErrorEnum {
    BUSINESS_ERROR(1001, "{0}"),
    SYSTEM_ERROR(1002, "系统开小差啦，请稍后再试~"),

    ;

    private final Integer code;
    private final String msg;

    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }
}
