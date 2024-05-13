package com.wusy.designpatterns.behavioral.command;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:05
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
