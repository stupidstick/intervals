package com.stupidstick.intervals.components.merge.impl;

import com.stupidstick.intervals.components.merge.IntervalsMerger;
import com.stupidstick.intervals.model.Interval;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class IntervalsMergerImpl implements IntervalsMerger {

    @Override
    public <T extends Comparable<T>> List<Interval<T>> merge(List<Interval<T>> intervals) {
        if (intervals == null)
            return null;
        if (intervals.isEmpty())
            return intervals;

        intervals = new ArrayList<>(intervals);
        intervals.sort(Comparator.comparing(Interval::getStart));
        return mergeSortedIntervals(intervals);
    }

    private <T extends Comparable<T>> List<Interval<T>> mergeSortedIntervals(List<Interval<T>> intervals) {
        List<Interval<T>> result = new ArrayList<>();
        var currentInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            var secondInterval = intervals.get(i);
            if (ObjectUtils.compare(currentInterval.getEnd(), secondInterval.getStart()) >= 0) {
                currentInterval.setEnd(ObjectUtils.max(currentInterval.getEnd(), secondInterval.getEnd()));
            } else {
                result.add(currentInterval);
                currentInterval = new Interval<>(secondInterval);
            }
        }
        result.add(currentInterval);
        return result;
    }
}
