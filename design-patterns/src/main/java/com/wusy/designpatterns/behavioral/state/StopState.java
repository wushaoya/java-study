package com.wusy.designpatterns.behavioral.state;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 17:02
 */
public class StopState implements State {

    public void doAction(Context context) {
        System.out.println("设置停止状态");
        context.setState(this);
    }

    public String toString(){
        return "停止状态";
    }
}
