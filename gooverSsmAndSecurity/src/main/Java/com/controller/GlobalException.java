package com.controller;

import com.Exception.userException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局错误管理
 * Created by han on 2016/9/29.
 */
@Controller
public class GlobalException implements HandlerExceptionResolver {


    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
       String message=null;

       if(ex instanceof userException) {
           message = ((userException) ex).getMessage();
       }else {
           message = "系统出错 稍后再试";
       }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("none/error");
        return modelAndView;
    }


}
