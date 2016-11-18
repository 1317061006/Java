package com.controller;

import com.Exception.userException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by han on 2016/9/14.
 */
@Controller
@RequestMapping("/none")
public class noneController {


    @RequestMapping("/fail")
    public void fail(ModelAndView modelAndView) {
        modelAndView.addObject("/none/fail");
    }

    @RequestMapping("/fail2")
    public void fail2(ModelAndView modelAndView) {
        modelAndView.addObject("/none/fail2");
    }

    @RequestMapping("/error")
    public String erro() {
        return "none/error";
    }

    @RequestMapping("/exception")
    public void exception() throws userException {
        throw new userException("测试异常");
    }

    @RequestMapping("/JSONTest01")
    public String Testo1(Map<String, Object> model) {
        System.out.println("访问到JSONTest01");
        return "none/JsonTest";
    }

    @RequestMapping("/resolveJsonObject")
    public void resolveJsonObject(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println("访问到resolveJsonObject");
        //解码
        String str = URLDecoder.decode(request.getParameter("orderJson"), "UTF-8");
        System.out.println(str);
        //将Json格式的字符串转换为JSON对象 并取到该对象的“username”属性值
        JSONObject jsonObject = JSON.parseObject(str);
        String username = (String) jsonObject.get("userName");
        System.out.println(username);
    }

    @RequestMapping("/resolveJsonArray")
    public void resolveJsonArray(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("访问到resolveJsonArray");
        //解码 为了防止中文乱码
        String str = null;
        try {
            str = URLDecoder.decode(request.getParameter("orderJson"), "UTF-8");
            System.out.println(str);
            JSONObject jsonObject = JSON.parseObject(str);//首先用JSONObject转换为内置JSON格式
            JSONArray jsonArray = (JSONArray) jsonObject.get("menu");//获取对应在JSONObject对应的JSONArray
            JSONObject o = (JSONObject) jsonArray.get(0);//获取JSONArray中第一个元素再转换为JSONObject
            String name = o.get("userName").toString();//JSONObject获取对应userName的值转换为String打印
            System.out.println(name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping("/resolveJson")
    public void resolveJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List m = new ArrayList();
        JSONArray Jsons = new JSONArray();
        for (int i = 0; i <10 ; i++) {//添加10个用户
            User user = new User();
            user.setUserName("name_"+ i);
            m.add(user);
        }

        for (int j = 0; j < m.size(); j++) {//将这些用户添加到JSONObject中
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user", m.get(j));
            Jsons.add(jsonObject);
        }
        //response响应返回
        response.getWriter().print(Jsons.toString());
    }


}


