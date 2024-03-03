package com.stupidstick.intervals.service;

import com.stupidstick.intervals.model.Interval;

import java.util.List;

public interface IntervalsService<T extends Comparable<T>> {
    List<Interval<T>> save(List<Interval<T>> intervals);

    Interval<T> findMin();
}
