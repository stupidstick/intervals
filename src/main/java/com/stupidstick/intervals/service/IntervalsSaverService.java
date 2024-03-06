package com.stupidstick.intervals.service;

import com.stupidstick.intervals.entity.BaseInterval;
import com.stupidstick.intervals.repository.IntervalsRepository;

import java.util.List;

public interface IntervalsSaverService<EN extends BaseInterval<T>, T> {

    void saveIntervals(IntervalsRepository<EN, T, ?> repository, List<EN> intervals);
}
