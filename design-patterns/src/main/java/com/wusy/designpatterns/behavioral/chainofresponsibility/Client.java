package com.wusy.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:40
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setNextHandler(handler2);

        Request request1 = new Request("type1", "请求1");
        Request request2 = new Request("type2", "请求2");

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
    }
}
