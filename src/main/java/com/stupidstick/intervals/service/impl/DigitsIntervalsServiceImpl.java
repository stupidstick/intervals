package com.stupidstick.intervals.service.impl;

import com.stupidstick.intervals.components.merge.IntervalsMerger;
import com.stupidstick.intervals.converters.interval.BaseIntervalMapper;
import com.stupidstick.intervals.converters.interval.BaseIntervalToIntervalConverter;
import com.stupidstick.intervals.entities.DigitsInterval;
import com.stupidstick.intervals.exceptions.MinimumIntervalNotFoundException;
import com.stupidstick.intervals.model.Interval;
import com.stupidstick.intervals.repositories.DigitsIntervalsRepository;
import com.stupidstick.intervals.service.DigitsIntervalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DigitsIntervalsServiceImpl implements DigitsIntervalsService {
    private final IntervalsMerger intervalsMerger;
    private final DigitsIntervalsRepository intervalsRepository;
    private final IntervalsSaverService saverService;
    private final BaseIntervalMapper baseMapper;
    private final BaseIntervalToIntervalConverter intervalConverter;

    @Override
    public Interval<BigInteger> findMin() {
        var minInterval = intervalsRepository.findMin()
                .orElseThrow(() -> new MinimumIntervalNotFoundException("Minimum digits interval not found"));
        return intervalConverter.convert(minInterval);
    }

    @Override
    public List<Interval<BigInteger>> save(List<Interval<BigInteger>> intervals) {
        List<Interval<BigInteger>> mergedList = intervalsMerger.merge(intervals);
        saverService.saveIntervalsIfNotExists(intervalsRepository, mergedList.stream()
                .map(i -> baseMapper.map(i, new DigitsInterval())).toList());
        return mergedList;
    }
}
