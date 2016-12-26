package com.Test.Exception;

/**
 * Created by han on 2016/12/20.
 */

public class OrderNotFoundException extends Exception {

    private  String  id;


    public OrderNotFoundException(String id)
    {
         this.id=id;
    }

    public String getOrderId(){
        return  id;
    }

}
