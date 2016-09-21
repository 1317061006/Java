package com.controller;

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
}


