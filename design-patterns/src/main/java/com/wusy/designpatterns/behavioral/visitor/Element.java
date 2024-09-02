package com.wusy.designpatterns.behavioral.visitor;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:50
 */
public interface Element {
    void accept(Visitor visitor);
}
