package com.wusy.designpatterns.behavioral.iterator;

import java.util.List;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:38
 */
public class IteratorPatternConcreteIterator<T> implements IteratorPatternIterator<T> {
    private List<T> list;
    private int position;

    public IteratorPatternConcreteIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(position++);
    }
}
