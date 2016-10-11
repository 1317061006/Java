package com.controller;

import com.Exception.userException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by han on 2016/9/14.
 */
@Controller
@RequestMapping("/none")
public class noneController {


    @RequestMapping("/fail")
  public  void fail(ModelAndView modelAndView) {
        modelAndView.addObject("/none/fail");
    }

    @RequestMapping("/fail2")
    public  void fail2(ModelAndView modelAndView) {
        modelAndView.addObject("/none/fail2");
    }

    @RequestMapping("/error")
    public  String erro(){
        return "none/error";
    }

    @RequestMapping("/exception")
    public  void  exception() throws userException {
        throw new userException("测试异常");
    }
}


