package com.stupidstick.intervals.repositories;

import com.stupidstick.intervals.entities.BaseInterval;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface IntervalsRepository<EN extends BaseInterval<T>, T, ID> extends CrudRepository<EN, ID> {
    boolean existsByStartAndEnd(T start, T end);

    Optional<EN> findMin();
}
