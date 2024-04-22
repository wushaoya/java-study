package com.wusy.designpatterns.creational.prototype;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:41
 */
public class Square extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
