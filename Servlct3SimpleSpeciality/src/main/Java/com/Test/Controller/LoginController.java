package com.Test.Controller;

import com.Test.Exception.NotFoundException;
import com.Test.Exception.fileException;
import com.Test.entity.User;
import com.Test.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.util.List;


/**
 * Created by han on 2016/11/19.
 */
@Controller
@RequestMapping("/")
public class LoginController {


    ImageUtil imageUtil = new ImageUtil();


    @RequestMapping("test")
    public String test() {

        return "test";
    }



    @RequestMapping("file")
    public String file(Model model) {
        User User = new User();
        model.addAttribute("user", User);
        return "file";
    }



      @RequestMapping("NotFound")
    public  String NotFoundException() throws com.Test.Exception.NotFoundException{
        throw  new NotFoundException("没有这个页面");
    }

    @RequestMapping("Exception")
    public String Exception() throws Exception
    {
        throw new Exception();
    }


    @RequestMapping("fileException")
    public  String fileException() throws  fileException {
            throw new fileException();
    }


    @RequestMapping("login")
    public String login() {

        return "login";
    }


    @RequestMapping(value = "Success")
    public String fileSucess(@Valid User User,Errors errors, @RequestPart(value = "profilePicture", required = false) Part image) {
        if(image !=null) {
            imageUtil.saveImage(User.getName(), image);
        }
        if(errors.hasErrors()){
            return "register";
        }
        return "Success";
    }


      @RequestMapping(value = "register")
      public  String  register(@Valid User User,Errors errors,Model model ) {
          model.addAttribute("user", User);
          return "register";
      }



    @RequestMapping("login_success")
    public String success(){
        return "login_success";
    }



    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }


}
