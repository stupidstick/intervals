package com.stupidstick.intervals.model;

import jakarta.validation.constraints.AssertTrue;

import java.util.ArrayList;

public final class IntervalRequest<T extends Comparable<T>> extends ArrayList<T> {

    @AssertTrue(message = "Interval size must be 2")
    private boolean isIntervalSize() {
        return size() == 2;
    }

    @AssertTrue(message = "Interval start value must be greatest then end value")
    private boolean isIntervalBounds() {
        if (!isIntervalSize())
            return true;
        return get(0).compareTo(get(1)) <= 0;
    }
}
