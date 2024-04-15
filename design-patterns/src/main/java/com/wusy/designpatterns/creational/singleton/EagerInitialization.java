package com.wusy.designpatterns.creational.singleton;

/**
 * 饿汉式单例模式
 *
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 14:46
 */
public class EagerInitialization {
    private static final EagerInitialization instance = new EagerInitialization();

    private EagerInitialization() {
    }

    public static EagerInitialization getInstance() {
        return instance;
    }
}
