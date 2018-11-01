package com.springmysql.financial.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        for(GrantedAuthority auth: authentication.getAuthorities()) {
            System.out.println(auth.getAuthority());
            if (auth.getAuthority().equals("USER")) {
                httpServletResponse.sendRedirect("user/home");
            } else if (auth.getAuthority().equals("ADMIN")){
                httpServletResponse.sendRedirect("admin/home");
            } else throw new IllegalStateException();
        }
    }
}