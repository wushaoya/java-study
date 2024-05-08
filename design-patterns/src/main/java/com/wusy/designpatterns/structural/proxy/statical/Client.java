package com.wusy.designpatterns.structural.proxy.statical;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:08
 */
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
