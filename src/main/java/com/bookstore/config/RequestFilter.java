package com.bookstore.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DG on 8/3/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter {

    public  void doFilter(ServletRequest req, ServletResponse res, FilterChain chain){
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Allow-Headers","x-request-with, x-auth-token");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Aceess-Control-Allow-Credentials","true");

        if(!(request.getMethod().equalsIgnoreCase("OPTIONS"))){
            try {
                chain.doFilter(req,res);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Pre-figth");
            response.setHeader("Access-Control-Allow-Methods", "POST,PUT,GET,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type,  x-request-with, x-auth-token," +
                    "access-control-request-headers, access-control-request-method, accept, origin");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    public void init(FilterConfig filterConfig){
    }
    public void destroy(){}
}
