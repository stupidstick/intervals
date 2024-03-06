package com.stupidstick.intervals.converter.interval;

import com.stupidstick.intervals.model.Interval;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntervalToListConverter {
    public <T extends Comparable<T>> List<T> convert(Interval<T> interval) {
        return List.of(interval.getStart(), interval.getEnd());
    }
}
