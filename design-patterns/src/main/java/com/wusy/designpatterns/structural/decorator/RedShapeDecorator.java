package com.wusy.designpatterns.structural.decorator;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:12
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("红色边");
    }
}
