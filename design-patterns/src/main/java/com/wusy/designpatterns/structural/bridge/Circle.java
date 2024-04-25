package com.wusy.designpatterns.structural.bridge;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 13:36
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
