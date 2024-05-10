package com.wusy.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 16:39
 */
public class ConcreteHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        // 判断是否能处理该请求
        if (request.getType().equals("type1")) {
            System.out.println("ConcreteHandler处理了请求：" + request.getContent());
        } else {
            // 无法处理则传递给下一个处理者
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("没有处理者能够处理该请求！");
            }
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
