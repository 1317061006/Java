package com.controller;

import com.Exception.ImageUploadException;
import com.entity.User;
import com.google.code.kaptcha.Constants;
import com.service.UserService;
import com.utils.imageUtiles;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by han on 2016/9/7.
 */
@Controller
@RequestMapping("/test")
public class loginController {

    @Autowired
    public UserService userService;

    @Autowired
    public imageUtiles imageUtiles;



    @RequestMapping({"/hello"})
    public String showHomePage(Map<String, Object> model, User user) {
        List<User> users = new ArrayList<User>();
        users.add(userService.getUserById(1));
        model.put("hello", new String("test hello"));
        model.put("User", users);
        model.put("user2", user);
        return "hello";
    }




    @RequestMapping(value = {"/hello2"}, method = RequestMethod.GET)
    public String showHomepage2(@RequestParam("test") String username, Model model) {
        User user = userService.getUserById(1);
        model.addAttribute(user);
        model.addAttribute("username", username);
        model.addAttribute(user.getUserName());
        model.addAttribute("hello2", "/test/hello2");
        return "hello2";
    }


    @RequestMapping(method = RequestMethod.GET, params = "new")
    public ModelAndView CreateUser() {

        return new ModelAndView("hello3", "user", new User());
    }


    @RequestMapping(value = "index")
    public String index_main() {
        return "Hello_Main";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addUserFromFrom(@Valid User user, BindingResult errors,
                                  @RequestParam(value = "image", required = false) MultipartFile image) {

        if (errors.hasErrors()) {
            return "hello3";
        }

        System.out.println(user.toString());

        userService.SaveUser(user);

        if (!image.isEmpty()) {
            try {
                imageUtiles.validateImage(image);
                imageUtiles.saveImage(user.getUserName() , image);
                imageUtiles.ceshi();
//                image.transferTo(new File("/" + "resources/" + user.getUserName()));
            } catch (ImageUploadException e) {
                e.printStackTrace();
            }
        }


        return "redirect:/test/" + user.getUserName();
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable String username, ModelMap modelMap) {
        modelMap.addAttribute("id", userService.getUserByUsername(username).getId());
        modelMap.addAttribute("userName", userService.getUserByUsername(username).getUserName());
        return "hello5";
    }


    @RequestMapping(value = "/login")
    public String login( ){
        return "login";
    }

    @RequestMapping(value = "/login.do")
    public String login2(){
        return "login2";
    }

    @RequestMapping(value = "login_failure")
    public String loginfailure() {
        return "login_failure";
    }


    @RequestMapping(value = "login_sucesss")
    public String login_sucesss( ) {
        return "login_sucesss";
    }


    @RequestMapping(value = "/logout.do")
   public  String logout(){
        return  "login_failure";
    }

    @RequestMapping(value = "/login_sucesss2")
    public  String login_sucesss2(){
        return "login_sucesss2";
    }

    @RequestMapping(value = "/login_sucesss3")
    public  String login_sucesss3(){
        return "login_sucesss3";
    }
}


