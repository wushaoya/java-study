package com.wusy.designpatterns.creational.singleton;

/**
 * 静态内部类
 *
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 15:03
 */
public class StaticInnerClass {
    private StaticInnerClass() {
    }

    private static class SingletonHolder {
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
