package com.stupidstick.intervals.entities;


public interface BaseInterval<T> {
    void setStart(T start);

    T getStart();

    void setEnd(T end);

    T getEnd();
}
