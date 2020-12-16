package edu.gdut.togethertime.exception;

public class BaseException extends RuntimeException {
    private Integer code;
    private String errMsg;

    public BaseException(Integer code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "code=" + code +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
