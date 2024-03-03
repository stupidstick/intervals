package com.stupidstick.intervals.service.impl;

import com.stupidstick.intervals.entities.BaseInterval;
import com.stupidstick.intervals.repositories.IntervalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntervalsSaverService {

    @Transactional
    public <T extends BaseInterval<IN>, IN> void saveIntervalsIfNotExists(IntervalsRepository<T, IN, ?> repository, List<T> intervals) {
        for (var interval: intervals) {
            if (!repository.existsByStartAndEnd(interval.getStart(), interval.getEnd())) {
                repository.save(interval);
            }
        }
    }

}
