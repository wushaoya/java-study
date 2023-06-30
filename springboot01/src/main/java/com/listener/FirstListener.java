package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;

/**
 * <listener>
 *     <listener-class>com.listener.FirstListener</listener-class>
 * </listener>
 * @date 2021/8/25
 */

public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FirstListener....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
