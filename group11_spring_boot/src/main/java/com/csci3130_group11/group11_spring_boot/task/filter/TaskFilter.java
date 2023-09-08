package com.csci3130_group11.group11_spring_boot.task.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TaskFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LOGGER.info("In task Filter...");
        LOGGER.info("[TaskFilter] - Inside doFilter method");
        LOGGER.info("Local Port : " + servletRequest.getLocalPort());
        LOGGER.info("Server Name : " + servletRequest.getServerName());

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        LOGGER.info("Method Name : " + httpServletRequest.getMethod());
        LOGGER.info("Request URI : " + httpServletRequest.getRequestURI());
        LOGGER.info("Servlet Path : " + httpServletRequest.getServletPath());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
