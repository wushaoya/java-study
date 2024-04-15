package com.wusy.designpatterns.creational.singleton;

/**
 * 懒汉式单例模式
 *
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 14:46
 */
public class LazyInitialization {
    private static LazyInitialization instance;

    private LazyInitialization() {
    }

    public static synchronized LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
