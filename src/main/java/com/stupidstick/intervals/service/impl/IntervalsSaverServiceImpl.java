package com.stupidstick.intervals.service.impl;

import com.stupidstick.intervals.entity.BaseInterval;
import com.stupidstick.intervals.repository.IntervalsRepository;
import com.stupidstick.intervals.service.IntervalsSaverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntervalsSaverServiceImpl<EN extends BaseInterval<T>, T> implements IntervalsSaverService<EN, T> {

    @Transactional
    public void saveIntervals(IntervalsRepository<EN, T, ?> repository, List<EN> intervals) {
        for (var interval: intervals) {
            if (!repository.existsByStartAndEnd(interval.getStart(), interval.getEnd())) {
                repository.save(interval);
            }
        }
    }

}
