package com.wusy.designpatterns.structural.proxy.dynamic;

import com.wusy.designpatterns.structural.proxy.statical.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:09
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Subject realSubject;

    public DynamicProxyHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理");
        Object result = method.invoke(realSubject, args);
        System.out.println("结束代理");
        return result;
    }
}
