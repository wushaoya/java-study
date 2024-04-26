package com.wusy.designpatterns.structural.composite;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:01
 */
public class Client {
    public static void main(String[] args) {
        // 创建叶子节点
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();

        // 创建组合节点，并添加叶子节点
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        // 执行组合节点的操作方法
        composite.operation();
    }
}
