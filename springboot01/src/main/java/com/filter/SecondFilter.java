package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * <filter>
 * <filter-name>FirstFilter</filter-name>
 * <filter-class>com.filter.FirstFilter</filter-class>
 * </filter>
 * <filter-mapping>
 * <filter-name>FirstFilter</filter-name>
 * <url-pattern>/first</url-pattern>
 * </filter-mapping>
 *
 * @date 2021/8/25
 */
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入SecondFilter...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开SecondFilter...");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
