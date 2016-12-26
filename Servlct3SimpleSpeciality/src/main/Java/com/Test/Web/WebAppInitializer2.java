package com.Test.Web;


import javax.servlet.*;

/**
 * Created by han on 2016/11/19.
 */
public class WebAppInitializer2 /* implements WebApplicationInitializer*/{


    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myServlet =
                servletContext.addServlet("myservlet", Myservlet.class);
        myServlet.addMapping("/custom/**");
        myServlet.setMultipartConfig(new MultipartConfigElement("D://测试",2097152,4194304,0));

        FilterRegistration.Dynamic fileter =
                servletContext.addFilter("myFileter",MyFilter.class);
        fileter.addMappingForUrlPatterns(null,false,"/custom/*");
    }



}
