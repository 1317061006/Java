package com.Test.Exception;

/**
 * Created by han on 2016/12/20.
 */
public class ERROR {


    private int code;

    private String message;

    public ERROR(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
