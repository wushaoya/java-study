package com.wusy.designpatterns.behavioral.mediator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:25
 */
public interface Colleague {
    void sendMessage(String message);
    void receiveMessage(String message);
}
