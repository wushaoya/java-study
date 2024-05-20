package com.wusy.designpatterns.behavioral.mediator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:25
 */
public interface Mediator {
    void sendMessage(String message, Colleague colleague);
}
