package edu.gdut.togethertime.exception;

public class BusinessException extends BaseException {

    public BusinessException(Integer code, String msg) {
        super(code, msg);
    }
}
