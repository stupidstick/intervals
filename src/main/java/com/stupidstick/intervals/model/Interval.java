package com.stupidstick.intervals.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interval<T extends Comparable<T>> {
    private T start;
    private T end;

    public Interval(Interval<T> interval) {
        this.start = interval.start;
        this.end = interval.end;
    }
}