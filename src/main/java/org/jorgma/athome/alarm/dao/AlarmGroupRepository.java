package org.jorgma.athome.alarm.dao;

import org.jorgma.athome.alarm.domain.AlarmGroup;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jorgma on 2018-09-07.
 */
public interface AlarmGroupRepository extends PagingAndSortingRepository<AlarmGroup, Integer> {
}
