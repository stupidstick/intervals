package com.stupidstick.intervals.converters.interval;

import com.stupidstick.intervals.entities.BaseInterval;
import com.stupidstick.intervals.model.Interval;
import org.springframework.stereotype.Component;

@Component
public class BaseIntervalMapper {
    public <EN extends BaseInterval<T>, T extends Comparable<T>> EN map(Interval<T> source, EN destination) {
        destination.setStart(source.getStart());
        destination.setEnd(source.getEnd());
        return destination;
    }
}
