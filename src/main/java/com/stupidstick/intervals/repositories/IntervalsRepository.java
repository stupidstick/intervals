package com.stupidstick.intervals.repositories;

import com.stupidstick.intervals.entities.BaseInterval;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface IntervalsRepository<T extends BaseInterval<IN>, IN, ID> extends CrudRepository<T, ID> {
    boolean existsByStartAndEnd(IN start, IN end);

    Optional<T> findMin();
}
