package com.wusy.designpatterns.structural.flyweight;

import java.util.HashMap;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:46
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
