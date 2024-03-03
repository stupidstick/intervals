package com.stupidstick.intervals.service.impl;

import com.stupidstick.intervals.components.merge.IntervalsMerger;
import com.stupidstick.intervals.converters.interval.BaseIntervalMapper;
import com.stupidstick.intervals.converters.interval.BaseIntervalToIntervalConverter;
import com.stupidstick.intervals.entities.LettersInterval;
import com.stupidstick.intervals.exceptions.MinimumIntervalNotFoundException;
import com.stupidstick.intervals.model.Interval;
import com.stupidstick.intervals.repositories.LettersIntervalsRepository;
import com.stupidstick.intervals.service.LettersIntervalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LettersIntervalsServiceImpl implements LettersIntervalsService {
    private final IntervalsMerger intervalsMerger;
    private final LettersIntervalsRepository repository;
    private final IntervalsSaverService saverService;
    private final BaseIntervalMapper baseMapper;
    private final BaseIntervalToIntervalConverter intervalConverter;

    @Override
    public Interval<String> findMin() {
        var minInterval = repository.findMin()
                .orElseThrow(() -> new MinimumIntervalNotFoundException("Minimum letters interval not found"));
        return intervalConverter.convert(minInterval);
    }

    @Override
    public List<Interval<String>> save(List<Interval<String>> intervals) {
        List<Interval<String>> mergedIntervals = intervalsMerger.merge(intervals);
        saverService.saveIntervalsIfNotExists(repository, mergedIntervals.stream()
                .map((i) -> baseMapper.map(i, new LettersInterval())).toList());
        return mergedIntervals;
    }
}
