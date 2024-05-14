package com.wusy.designpatterns.behavioral.interpreter;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 11:13
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
