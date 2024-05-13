package com.wusy.designpatterns.behavioral.command;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:06
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
