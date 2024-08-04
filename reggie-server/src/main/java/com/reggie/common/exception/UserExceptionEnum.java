package com.reggie.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserExceptionEnum implements ErrorEnum{

    USER_IS_NOT_EXIST(10021, "用户不存在"),
    USER_PASSWORD_ERROR(10022, "用户密码错误");

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
