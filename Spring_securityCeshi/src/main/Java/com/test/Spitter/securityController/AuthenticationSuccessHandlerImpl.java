package com.test.Spitter.securityController;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * authentication-success-handler-ref ��Ӧһ�� AuthencticationSuccessHandler ʵ��������á�
 * ���ָ���� authentication-success-handler-ref��
 * ��¼��֤�ɹ�������ָ�� AuthenticationSuccessHandler �� onAuthenticationSuccess ������
 * ������Ҫ�ڸ÷������ڶ���֤�ɹ���һ������Ȼ�󷵻ض�Ӧ����֤�ɹ�ҳ�档
 * ʹ���� authentication-success-handler-ref ֮����֤�ɹ���Ĵ������ָ���� AuthenticationSuccessHandler ������
 * ֮ǰ����Щ default-target-url ֮��ľͶ����������ˡ�
 * Created by han on 2016/8/5.
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request,
                                       HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.sendRedirect(request.getContextPath()+"login_sucesss");
    }


}
