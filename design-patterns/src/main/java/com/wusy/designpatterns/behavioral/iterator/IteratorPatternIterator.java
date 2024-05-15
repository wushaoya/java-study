package com.wusy.designpatterns.behavioral.iterator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:37
 */
public interface IteratorPatternIterator<T> {
    boolean hasNext();
    T next();
}
