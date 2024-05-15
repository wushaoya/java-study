package com.wusy.designpatterns.behavioral.iterator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:38
 */
public interface IteratorPatternAggregate<T> {
    IteratorPatternIterator<T> createIterator();
}
