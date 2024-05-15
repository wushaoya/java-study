package com.wusy.designpatterns.behavioral.iterator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:39
 */
public class Client {
    public static void main(String[] args) {
        // 创建具体聚合对象
        IteratorPatternConcreteAggregate<String> aggregate = new IteratorPatternConcreteAggregate<>();

        // 添加元素到聚合对象
        aggregate.add("Element 1");
        aggregate.add("Element 2");
        aggregate.add("Element 3");

        // 创建迭代器并遍历聚合对象
        IteratorPatternIterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
