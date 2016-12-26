package com.Test.Controller;

import com.Test.Exception.ERROR;
import com.Test.Exception.OrderNotFoundException;
import com.Test.Exception.fileException;
import com.Test.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by han on 2016/11/20.
 */
@ControllerAdvice
public class GolbalException {

    @ExceptionHandler(fileException.class)
    public String handleFileException(){
        return "error";
    }


    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ERROR> OrderNotFound(OrderNotFoundException e){
        String id=e.getOrderId();
        ERROR error = new ERROR(4, "Order id: " + id + "not found");
        return new ResponseEntity<ERROR>(error, HttpStatus.NOT_FOUND);
    }


}
