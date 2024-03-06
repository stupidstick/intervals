package com.stupidstick.intervals.service.impl;

import com.stupidstick.intervals.components.merge.IntervalsMerger;
import com.stupidstick.intervals.converter.interval.BaseIntervalMapper;
import com.stupidstick.intervals.converter.interval.BaseIntervalToIntervalConverter;
import com.stupidstick.intervals.entity.BaseInterval;
import com.stupidstick.intervals.exception.MinimumIntervalNotFoundException;
import com.stupidstick.intervals.model.Interval;
import com.stupidstick.intervals.repository.IntervalsRepository;
import com.stupidstick.intervals.service.IntervalsSaverService;
import com.stupidstick.intervals.service.IntervalsService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class IntervalsServiceImpl<IN extends Comparable<IN>, EN extends BaseInterval<IN>> implements IntervalsService<IN> {
    private final IntervalsRepository<EN, IN, ?> repository;
    private final IntervalsSaverService<EN, IN> saverService;
    private final BaseIntervalToIntervalConverter converter;
    private final IntervalsMerger merger;
    private final BaseIntervalMapper mapper;
    private final Supplier<EN> entitySupplier;

    @Override
    public List<Interval<IN>> save(List<Interval<IN>> intervals) {
        List<Interval<IN>> mergedList = merger.merge(intervals);
        saverService.saveIntervals(repository, mergedList.stream()
                .map(i -> mapper.map(i, entitySupplier.get())).toList());
        return mergedList;
    }

    @Override
    public Interval<IN> findMin() {
        var minInterval = repository.findMin()
                .orElseThrow(() -> new MinimumIntervalNotFoundException("Minimum digits interval not found"));
        return converter.convert(minInterval);
    }
}
