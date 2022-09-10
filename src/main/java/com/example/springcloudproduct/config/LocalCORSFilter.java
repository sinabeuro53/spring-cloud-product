package com.example.springcloudproduct.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LocalCORSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD, PATCH");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Max-Age", "3600");
         res.setHeader("Access-Control-Allow-Headers", "*");
        //        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, X-MEM-NO, X-SITE-CD");

        chain.doFilter(request, response);
    }
}
