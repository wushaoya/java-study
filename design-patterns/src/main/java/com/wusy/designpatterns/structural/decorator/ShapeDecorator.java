package com.wusy.designpatterns.structural.decorator;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:11
 */
public abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
