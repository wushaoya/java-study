package com.wusy.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:38
 */
public interface Handler {
    void handleRequest(Request request);
    void setNextHandler(Handler nextHandler);
}
