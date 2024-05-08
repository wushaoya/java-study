package com.wusy.designpatterns.structural.proxy.dynamic;

import com.wusy.designpatterns.structural.proxy.statical.RealSubject;
import com.wusy.designpatterns.structural.proxy.statical.Subject;

import java.lang.reflect.Proxy;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:10
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        DynamicProxyHandler handler = new DynamicProxyHandler(realSubject);
        Subject proxy = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                handler);
        proxy.request();
    }
}
