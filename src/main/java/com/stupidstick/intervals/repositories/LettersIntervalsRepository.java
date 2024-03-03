package com.stupidstick.intervals.repositories;

import com.stupidstick.intervals.entities.LettersInterval;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LettersIntervalsRepository extends IntervalsRepository<LettersInterval, String, Long>{
    @Override
    boolean existsByStartAndEnd(String start, String end);

    @Override
    @Query(value = "SELECT * FROM letters_intervals WHERE " +
            "interval_start = (SELECT min(interval_start) FROM letters_intervals) AND " +
            "interval_end = (SELECT min(interval_end) FROM letters_intervals)", nativeQuery = true)
    Optional<LettersInterval> findMin();
}
