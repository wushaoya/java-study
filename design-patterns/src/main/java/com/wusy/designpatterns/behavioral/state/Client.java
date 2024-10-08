package com.wusy.designpatterns.behavioral.state;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 17:02
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
