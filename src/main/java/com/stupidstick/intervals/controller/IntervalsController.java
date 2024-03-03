package com.stupidstick.intervals.controller;

import com.stupidstick.intervals.converters.interval.IntervalRequestToIntervalConverter;
import com.stupidstick.intervals.converters.interval.IntervalToListConverter;
import com.stupidstick.intervals.model.Interval;
import com.stupidstick.intervals.model.IntervalRequest;
import com.stupidstick.intervals.service.DigitsIntervalsService;
import com.stupidstick.intervals.service.LettersIntervalsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intervals")
@RequiredArgsConstructor
public class IntervalsController {
    private final DigitsIntervalsService digitsIntervalsService;
    private final LettersIntervalsService lettersIntervalsService;
    private final IntervalRequestToIntervalConverter requestConverter;
    private final IntervalToListConverter intervalToListConverter;

    @GetMapping(value = "/min", params = "kind=digits")
    public List<BigInteger> findMinDigitsInterval() {
        var minInterval = digitsIntervalsService.findMin();
        return List.of(minInterval.getStart(), minInterval.getEnd());
    }

    @GetMapping(value = "/min", params = "kind=letters")
    public List<String> findMinLettersInterval() {
        var minInterval = lettersIntervalsService.findMin();
        return List.of(minInterval.getStart(), minInterval.getEnd());
    }


    @PostMapping(value = "/merge", params = "kind=digits")
    public List<List<BigInteger>> saveDigitsIntervals(@RequestBody @Valid List<IntervalRequest<BigInteger>> digitsIntervals) {
        List<Interval<BigInteger>> intervals = digitsIntervals.stream()
                .map(requestConverter::convert).toList();
        return digitsIntervalsService.save(intervals).stream()
                .map(intervalToListConverter::convert).toList();
    }

    @PostMapping(value = "/merge", params = "kind=letters")
    public List<List<String>> saveLettersIntervals(@RequestBody @Valid List<IntervalRequest<String>> lettersIntervals) {
        List<Interval<String>> intervals = lettersIntervals.stream()
                .map(requestConverter::convert).toList();
        return lettersIntervalsService.save(intervals).stream()
                .map(intervalToListConverter::convert).toList();
    }
}