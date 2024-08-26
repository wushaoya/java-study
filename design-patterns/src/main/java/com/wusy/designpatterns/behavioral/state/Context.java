package com.wusy.designpatterns.behavioral.state;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 17:01
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
