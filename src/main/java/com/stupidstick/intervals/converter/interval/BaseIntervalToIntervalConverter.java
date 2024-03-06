package com.stupidstick.intervals.converter.interval;

import com.stupidstick.intervals.entity.BaseInterval;
import com.stupidstick.intervals.model.Interval;
import org.springframework.stereotype.Component;

@Component
public class BaseIntervalToIntervalConverter {
    public <T extends Comparable<T>> Interval<T> convert(BaseInterval<T> interval) {
        return new Interval<>(interval.getStart(), interval.getEnd());
    }
}
