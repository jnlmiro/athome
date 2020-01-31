package org.jorgma.athome.sl.dao;

import org.jorgma.athome.sl.domain.Station;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by jorgma on 2018-02-21.
 */
public interface StationsRepository extends PagingAndSortingRepository<Station, Integer> {
    Station findBySiteId(int siteId);

    List<Station> findByEnabled(boolean enabled);
}
