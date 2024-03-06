package com.stupidstick.intervals.repository;

import com.stupidstick.intervals.entity.LettersInterval;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LettersIntervalsRepository extends IntervalsRepository<LettersInterval, String, Long>{
    @Override
    boolean existsByStartAndEnd(String start, String end);

    @Override
    @Query(value = "SELECT * FROM letters_intervals WHERE " +
            "interval_start = (SELECT min(interval_start) FROM letters_intervals) AND " +
            "interval_end = (SELECT min(interval_end) FROM letters_intervals)", nativeQuery = true)
    Optional<LettersInterval> findMin();
}
