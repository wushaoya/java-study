package com.wusy.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:38
 */
public class Request {
    private String type;
    private String content;

    public Request(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
