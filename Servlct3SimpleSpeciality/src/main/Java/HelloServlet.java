import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**Demo其实开始本身就是测试一下Servlet3 Servlet3的通过注解注册Servlet方式
 * Created by han on 2016/9/21.
 */

@WebServlet(name = "HelloServlet",urlPatterns = {"/HelloServlet"},loadOnStartup = 1,initParams = {
       @WebInitParam(name="name",value = "xiaofang"),
        @WebInitParam(name="age",value = "20")

})
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("GBK");
        ServletConfig config = getServletConfig();
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Hello World"+"<br />");
        out.println(config.getInitParameter("name"));
        out.println("</body>");
        out.println("</html>");

    }


}
