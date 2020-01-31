package org.jorgma.athome.alarm.business;

import org.jorgma.athome.alarm.domain.AlarmGroup;

import java.util.List;

/**
 * Created by jorgma on 2018-09-07.
 */
public interface AlarmGroupBl {
    List<AlarmGroup> getAlarmGroups();

    AlarmGroup createAlarmGroup(AlarmGroup alarmGroup);

    AlarmGroup updateAlarmGroup(int id, AlarmGroup alarmGroup);

    AlarmGroup getAlarmGroup(int id);
}
