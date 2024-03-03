package com.stupidstick.intervals.components.merge;

import com.stupidstick.intervals.model.Interval;

import java.util.List;

public interface IntervalsMerger {
    <T extends Comparable<T>> List<Interval<T>> merge(List<Interval<T>> intervals);
}
