package com.reggie.common.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{

    private Integer errorCode;

    private String errorMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(ErrorEnum error) {
        super(error.getErrorMsg());
        this.errorCode=error.getErrorCode();
        this.errorMsg=error.getErrorMsg();
    }
}
