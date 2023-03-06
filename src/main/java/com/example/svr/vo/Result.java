package com.example.svr.vo;

public class Result<T> {
    public int code;
    public String msg;
    public T data;

    // 构造方法
    public Result (int code, String msg, T data){
        this.code=code;
        this.data=data;
        this.msg=msg;
    }


    // static 方法
    public static Result success() {
        Result res = new Result(0,"suc", null);
        return res;
    }
    public static <T> Result success(T data) {
        Result res = new Result(0,"suc", data);
        return res;
    }


}
