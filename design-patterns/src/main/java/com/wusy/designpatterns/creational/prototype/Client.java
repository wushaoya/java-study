package com.wusy.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:42
 */
public class Client {
    public static void main(String[] args) {
        Square square = new Square();
        square.setId("1");
        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        Map<String, Shape> map = new HashMap<>();
        map.put(square.getId(), square);
        map.put(rectangle.getId(), rectangle);

        Shape clonedShape = (Shape) map.get("1").clone();
        clonedShape.draw();
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) map.get("2").clone();
        clonedShape2.draw();
        System.out.println("Shape : " + clonedShape2.getType());

    }
}
