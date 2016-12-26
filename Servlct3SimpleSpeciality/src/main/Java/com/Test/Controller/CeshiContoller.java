package com.Test.Controller;

import com.Test.Dao.NOSQL.Redis.RedisRepository;
import com.Test.Exception.OrderNotFoundException;
import com.Test.entity.Order;
import com.Test.entity.User;
import com.Test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by han on 2016/12/9.
 */
@Controller
@RequestMapping("/ceshi")
public class CeshiContoller {

    @Autowired
    RedisRepository redis;

    @Autowired
    UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String processRegistration(
            User User,RedirectAttributes model,Errors errors
    ) {

        if(errors.hasErrors()){
            return "error";
        }
        User.setName("luanqibaz");
        model.addAttribute("ce", "ce");
        model.addAttribute("username", User.getName());
        model.addAttribute("redis", redis.find("username").getCustomer());
        model.addFlashAttribute("user", User);
  /*测试Spring-security的安全注解所写  */
//        userService.TestSecured();
//        userService.TestPreAuthorize("不超过10个字");
//        userService.TestPostAuthorize(new User("username"));
//        List<User> userList = userService.PostTestListUser();
//        for (int i = 0; i <userList.size() ; i++) {
//            System.out.println(userList.get(i));
//        }
//        userService.PreTestListUser(userList);
//           userService.deleteUses(userList);
        return "redirect:/ceshi/{username}";
    }




    @RequestMapping(value = "{username}",method = RequestMethod.GET)
    public  String showSpitterProfil(@PathVariable String username,Model model ){
        if(!model.containsAttribute("user")){
            System.out.println("没有");
            System.out.println(username);
        }
        if(model.containsAttribute("user")) {
            System.out.println("有了");
            System.out.println(username);
        }
        model.addAttribute("username", username);
          /*测试Spring-security的安全注解所写 */
//        userService.TestRoles_Allowed();
        return "usernameTest";
    }


    @RequestMapping(value = "json",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<User> users() {
        return  userService.PostTestListUser();
    }



    @RequestMapping(value = "json",method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody User saveUser(@RequestBody User user){
        return        userService.TestPostAuthorize(user);
    }



    @RequestMapping(value = "RegisterOrder")
    public String RegisterOrder(@Valid Order order ,Errors errors,Model model) {
        model.addAttribute("order", order);
        return "RegisterOrder";
    }



}
