package edu.gdut.togethertime.exception;

public enum  ExceptionEnum {
    USER_NOT_EXIST(new UserException(4041, "用户不存在")),
    PARAM_NOT_EXIST(new ParamException(4042, "参数缺失")),
    TASK_NOT_EXIST(new TaskException(4043, "无此事项")),

    PARAM_ERROR(new ParamException(5001, "参数类型或取值错误")),
    SYSTEM_ERROR(new BaseException(500, "系统错误")),

    AUTH_ERROR(new BaseException(4031, "请求信息出错error auth")),

    REQUEST_ERROR(new BaseException(301, "外部请求失败"))
    ;

    private BaseException exception;

    ExceptionEnum(BaseException exception) {
        this.exception = exception;
    }

    public static BaseException exception(ExceptionEnum exceptionEnum) {
        return exceptionEnum.exception;
    }

    public static BaseException exception(String msg) {
        return new BaseException(500, msg);
    }
}
