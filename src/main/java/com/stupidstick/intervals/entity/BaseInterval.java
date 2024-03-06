package com.stupidstick.intervals.entity;


public interface BaseInterval<T> {
    void setStart(T start);

    T getStart();

    void setEnd(T end);

    T getEnd();
}
