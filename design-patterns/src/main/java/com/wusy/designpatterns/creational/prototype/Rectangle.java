package com.wusy.designpatterns.creational.prototype;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:40
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
