package com.Test.Controller;

import com.Test.Dao.NOSQL.Redis.RedisRepository;
import com.Test.entity.Order;
import com.Test.entity.User;
import com.Test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by han on 2016/12/9.
 */
@Controller
@RequestMapping("/ceshi")
public class CeshiContoller {

    @Autowired
  private   RedisRepository redis;

    @Autowired
  private   UserService userService;


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


    @RequestMapping(value = "/saveorder2",method = RequestMethod.POST )
    public String saveOrder2( @Valid Order order,Errors errors ) {
        if (errors.hasErrors()) {
            return "/RegisterOrder";
        }
        return "Success";
    }


    @RequestMapping("OrderPageTable")
    public String TestOrderPageTable(){
        return "Test/OrderPageTable";
    }


    @RequestMapping("TestCookie")
    public String TestCookie(){
        return "Test/TestCookie";
    }

    @RequestMapping("CookieTest")
    public void CookieTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>CookieTest</TITLE></HEAD>");
        out.println("  <BODY>");
        if (username != null && username != "") {
            Cookie cName = new Cookie("username", username);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Cookie cDate = new Cookie("lastVisited", format.format(new java.util.Date()));
            response.addCookie(cName);
            response.addCookie(cDate);
            out.println("Cookie保存成功");
            out.println("<br /><br />");
            out.println("<a href='/ceshi/getCookie'>读取Cookie内容</a>");
        }
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }


    @RequestMapping("getCookie")
    public void getCookie(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        Cookie[] cookies = request.getCookies();
        Cookie c = null;
        if (cookies!=null){
            for (int i=0;i<cookies.length;i++) {
                c = cookies[i];
                if (c.getName().equals("username")) {
                    out.println("用户名:" + c.getValue());
                    out.println("<br />");
                }
                if (c.getName().equals("lastVisited")) {
                    out.println("最后登录时间:" + c.getValue());
                    out.println("<br />");
                }
            }

            }else {
            out.println("No cookie Existing");
        }
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }


}
