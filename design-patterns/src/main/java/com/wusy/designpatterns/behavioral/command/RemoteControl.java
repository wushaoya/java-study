package com.wusy.designpatterns.behavioral.command;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:06
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
