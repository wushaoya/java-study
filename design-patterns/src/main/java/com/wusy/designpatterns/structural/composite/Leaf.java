package com.wusy.designpatterns.structural.composite;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:00
 */
public class Leaf implements Component{
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }
}
