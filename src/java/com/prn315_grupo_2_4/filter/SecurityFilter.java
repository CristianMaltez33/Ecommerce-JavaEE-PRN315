package com.prn315_grupo_2_4.filter;

import security.SecurityService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    private SecurityService securityService;

    public SecurityFilter() {
        securityService = new SecurityService();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Implementar la lógica de autenticación y autorización
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}