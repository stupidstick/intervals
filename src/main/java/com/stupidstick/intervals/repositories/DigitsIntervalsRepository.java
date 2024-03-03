package com.stupidstick.intervals.repositories;

import com.stupidstick.intervals.entities.DigitsInterval;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface DigitsIntervalsRepository extends IntervalsRepository<DigitsInterval, BigInteger, Long> {
    @Override
    boolean existsByStartAndEnd(BigInteger start, BigInteger end);

    @Override
    @Query(value = "SELECT * FROM digits_intervals WHERE " +
            "interval_start = (SELECT min(interval_start) FROM digits_intervals) AND " +
            "interval_end = (SELECT min(interval_end) FROM digits_intervals)", nativeQuery = true)
    Optional<DigitsInterval> findMin();
}
