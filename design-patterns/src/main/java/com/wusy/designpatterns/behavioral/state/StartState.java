package com.wusy.designpatterns.behavioral.state;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 17:02
 */
public class StartState implements State {

    public void doAction(Context context) {
        System.out.println("设置开启状态");
        context.setState(this);
    }

    public String toString(){
        return "开启";
    }
}
