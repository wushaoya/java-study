package com.wusy.designpatterns.structural.bridge;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 13:36
 */
public class Client {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
