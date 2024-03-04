package com.stupidstick.intervals.config;

import com.stupidstick.intervals.components.merge.IntervalsMerger;
import com.stupidstick.intervals.converters.interval.BaseIntervalMapper;
import com.stupidstick.intervals.converters.interval.BaseIntervalToIntervalConverter;
import com.stupidstick.intervals.entities.DigitsInterval;
import com.stupidstick.intervals.entities.LettersInterval;
import com.stupidstick.intervals.repositories.IntervalsRepository;
import com.stupidstick.intervals.service.IntervalsService;
import com.stupidstick.intervals.service.impl.IntervalsSaverService;
import com.stupidstick.intervals.service.impl.IntervalsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.util.function.Supplier;

@Configuration
public class IntervalsConfig {

    @Bean
    public Supplier<DigitsInterval> digitsIntervalSupplier() {
        return DigitsInterval::new;
    }

    @Bean
    public Supplier<LettersInterval> lettersIntervalSupplier() {
        return LettersInterval::new;
    }

    @Bean
    public IntervalsService<BigInteger> digitsIntervalsService(
            IntervalsRepository<DigitsInterval, BigInteger, ?> repository,
            IntervalsSaverService<DigitsInterval, BigInteger> saverService,
            BaseIntervalToIntervalConverter converter,
            IntervalsMerger merger,
            BaseIntervalMapper mapper,
            Supplier<DigitsInterval> digitsIntervalSupplier
    ) {
        return new IntervalsServiceImpl<>(
                repository,
                saverService,
                converter,
                merger,
                mapper,
                digitsIntervalSupplier
        );
    }

    @Bean
    public IntervalsService<String> lettersIntervalsService(
            IntervalsRepository<LettersInterval, String, ?> repository,
            IntervalsSaverService<LettersInterval, String> saverService,
            BaseIntervalToIntervalConverter converter,
            IntervalsMerger merger,
            BaseIntervalMapper mapper,
            Supplier<LettersInterval> lettersIntervalSupplier
    ) {
        return new IntervalsServiceImpl<>(
                repository,
                saverService,
                converter,
                merger,
                mapper,
                lettersIntervalSupplier
        );
    }

}
