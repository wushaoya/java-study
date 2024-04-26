package com.wusy.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:01
 */
public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    // 添加子节点
    public void add(Component component) {
        children.add(component);
    }

    // 移除子节点
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite operation");
        // 递归调用子节点的操作方法
        for (Component component : children) {
            component.operation();
        }
    }
}
