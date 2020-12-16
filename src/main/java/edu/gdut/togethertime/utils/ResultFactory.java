package edu.gdut.togethertime.utils;

public class ResultFactory<T> {
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("error");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(T data) {
        Result result = error();
        result.setData(data);
        return result;
    }

    public static Result error(String msg) {
        Result result = error();
        result.setMsg(msg);
        return result;
    }
}
