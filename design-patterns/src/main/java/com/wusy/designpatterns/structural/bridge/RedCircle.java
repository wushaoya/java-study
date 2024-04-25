package com.wusy.designpatterns.structural.bridge;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 13:35
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
