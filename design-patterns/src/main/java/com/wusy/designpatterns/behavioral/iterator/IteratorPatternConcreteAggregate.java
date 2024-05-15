package com.wusy.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:39
 */
public class IteratorPatternConcreteAggregate<T> implements IteratorPatternAggregate<T> {
    private List<T> list;

    public IteratorPatternConcreteAggregate() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    @Override
    public IteratorPatternIterator<T> createIterator() {
        return new IteratorPatternConcreteIterator<>(list);
    }
}
