package com.wusy.designpatterns.creational.singleton;

/**
 * 双重检查锁
 *
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 14:59
 */
public class DoubleCheckLock {
    private volatile static DoubleCheckLock instance;

    private DoubleCheckLock() {}

    public static DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLock.class) {
                if (instance == null) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
