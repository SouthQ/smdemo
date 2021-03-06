package com.example.demo.entity;

/**
 *  封装返回结果
 */
public class DataReturn<T> {

    /**
     * 错误码 0:success,1:error
     */
    private Integer code;

    /**
     * 提示信息
     */
    private  String msg;

    /**
     * 具体内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 为了处理请求打印日志-打印出返回结果的具体内容
    @Override
    public String toString() {
        return "DataReturn{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
