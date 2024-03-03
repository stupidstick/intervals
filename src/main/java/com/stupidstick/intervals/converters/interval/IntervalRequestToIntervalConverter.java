package com.stupidstick.intervals.converters.interval;

import com.stupidstick.intervals.model.Interval;
import com.stupidstick.intervals.model.IntervalRequest;
import org.springframework.stereotype.Component;

@Component
public class IntervalRequestToIntervalConverter {
    public <T extends Comparable<T>> Interval<T> convert (IntervalRequest<T> request) {
        return new Interval<>(request.get(0), request.get(1));
    }
}
