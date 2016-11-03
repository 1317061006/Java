package com.Exception;

/**
 * Created by han on 2016/9/29.
 */
public class userException extends  Exception {

    private  String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public userException(String message) {
        super(message);
        Integer integer=new Integer(2);
    }
}
