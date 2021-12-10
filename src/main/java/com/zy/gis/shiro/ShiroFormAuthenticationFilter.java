package com.zy.gis.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {

                return this.executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            String header = ((HttpServletRequest) request).getHeader("Content-Type");
            if(header == null) {
                this.saveRequestAndRedirectToLogin(request, response);
            } else if (header != null && header.equals("application/x-www-form-urlencoded")) {
                //application/json; charset=utf-8
                this.saveRequestAndRedirectToLogin(request, response);
            } else  {
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print("{\"message\" : please login }");
                out.flush();
                out.close();
            }
            return false;
        }
    }
}
