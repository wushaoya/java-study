package com.wusy.designpatterns.structural.decorator;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:11
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.print("圆圈");
    }
}
