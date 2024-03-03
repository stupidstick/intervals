package com.stupidstick.intervals.converters.interval;

import com.stupidstick.intervals.entities.BaseInterval;
import com.stupidstick.intervals.model.Interval;
import org.springframework.stereotype.Component;

@Component
public class BaseIntervalMapper {
    public <T extends BaseInterval<E>, E extends Comparable<E>> T map(Interval<E> source, T destination) {
        destination.setStart(source.getStart());
        destination.setEnd(source.getEnd());
        return destination;
    }
}
