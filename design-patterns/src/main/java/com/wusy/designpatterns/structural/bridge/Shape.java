package com.wusy.designpatterns.structural.bridge;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 13:36
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
