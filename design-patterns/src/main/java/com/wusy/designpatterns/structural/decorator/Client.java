package com.wusy.designpatterns.structural.decorator;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:12
 */
public class Client {
    public static void main(String[] args) {

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        redCircle.draw();
        System.out.println("=========");
        redRectangle.draw();
    }
}
