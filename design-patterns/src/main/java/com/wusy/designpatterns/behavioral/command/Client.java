package com.wusy.designpatterns.behavioral.command;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:06
 */
public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
