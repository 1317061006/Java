package com.Test.Web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/***
 * Created by han on 2016/11/17.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }


   /*
     * StandardServletMultipartResolver 方式配置multipart请求和文件上传
     * @param registration @Override*/
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    registration.setMultipartConfig(
            new MultipartConfigElement("D://测试", 2097152,4194304,0)//这里是指定临时文件夹与上传文件大小限制等
    );
    }



    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        FilterRegistration.Dynamic filter=servletContext.addFilter("CharacterEncodingFilter",org.springframework.web.filter.CharacterEncodingFilter.class);
        filter.setInitParameter("encoding","UTF-8");
        filter.addMappingForUrlPatterns(null,false,"/*");

        super.onStartup(servletContext);
    }



}
