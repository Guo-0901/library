package com.example.library.common;

public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode () {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public static Result ok (Object data) {
        return new Result(200, "成功", data);
    }

    public static Result fail (Integer code, String message) {
        return new Result(code, message, null);
    }
}
