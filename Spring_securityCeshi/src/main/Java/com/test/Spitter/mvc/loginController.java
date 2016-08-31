package com.test.Spitter.mvc;

import com.test.Spitter.service.MessageService;
import com.test.Spitter.service.MessageServiceImpl;
import com.test.Spitter.service.isecuritCeshi;
import com.test.Spitter.service.securitCeshi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by han on 2016/8/4.
 */
@Controller
public class loginController {


    @RequestMapping(value="/login")
    public String showHomePage( ) {
        return "login";
    }
    @RequestMapping(value="/login.do")
    public String showHomePage2( ) {
        return "login2";
    }
    @RequestMapping(value="/login_failure")
    public String showHomePage3( ) {
        return "login_failure";
    }
    @RequestMapping(value="/login_sucesss")
    public String showHomePage4( ) {
        return "login_sucesss";
    }

    @RequestMapping(value="/admin")
    public String showHomePage5( ) {
        return "admin";
    }
    @RequestMapping(value="/admin/admin")
    public String showHomePage6( ) {
        return "admin/admin";
    }

    @RequestMapping(value="/admin/**")
    public String showHomePage7( ) {
        return "admin/admin";
    }
    @RequestMapping(value="/logout.do")
    public String showHomePage8( ) {
        return "login_failure";
    }


    @RequestMapping(value="/login_sucesss2")
    public String showHomePage9( ) {

         ApplicationContext context=new ClassPathXmlApplicationContext("spitter-security.xml");
         MessageService messageService= (MessageService ) context.getBean("service");
        /*注意这个方法已经被我加上了ROLE_ADMIN权限 所以如果没有权限的话 会直接访问失败  暂时注释掉*/
        System.out.println(messageService.adminDate());
        System.out.println(messageService.adminMessage());
        System.out.println(messageService.userDate());
        System.out.println(messageService.userMessage());
        isecuritCeshi securitCeshi =  (isecuritCeshi) context.getBean("service2");
//        System.out.println(securitCeshi.ceshi1(10).toString());
        System.out.println(securitCeshi.ceshi2(10).toString());
        return "login_sucesss2";
    }

    @RequestMapping(value="/none/session_authentication_error.jsp")
    public String showHomePage10( ) {
        return "/none/session_authentication_error";
    }
    @RequestMapping(value="/Test/Test")
    public String showHomePage11( ) {
        return "/Test/Test";
    }
}
