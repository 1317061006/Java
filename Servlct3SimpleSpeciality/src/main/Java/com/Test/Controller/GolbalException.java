package com.Test.Controller;

import com.Test.Exception.ERROR;
import com.Test.Exception.OrderNotFoundException;
import com.Test.Exception.fileException;
import com.Test.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by han on 2016/11/20.
 */
@ControllerAdvice
public class GolbalException   {

    @ExceptionHandler(fileException.class)
    public ModelAndView handleFileException(Exception ex) {
        String message = ex.getMessage();
        if(message ==null){
            message="null 无信息";
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileException");
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ERROR> OrderNotFound(OrderNotFoundException e){
        String id=e.getOrderId();
        ERROR error = new ERROR(4, "Order id: " + id + " not found");
        return new ResponseEntity<ERROR>(error, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(Exception.class)
    public  ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String message = null;

        message="系统出错 原因："+ex.getMessage();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("Exception/error");
        return modelAndView;
    }

}
