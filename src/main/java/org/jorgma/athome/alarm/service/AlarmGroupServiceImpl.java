package org.jorgma.athome.alarm.service;

import org.jorgma.athome.alarm.business.AlarmGroupBl;
import org.jorgma.athome.alarm.domain.AlarmGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2018-09-07.
 */

@Service
public class AlarmGroupServiceImpl implements AlarmGroupService{

    @Autowired
    private AlarmGroupBl alarmGroupBl;

    @Override
    public List<AlarmGroup> getAlarmGroups() {
        return alarmGroupBl.getAlarmGroups();
    }

    @Override
    public AlarmGroup createAlarmGroup(AlarmGroup alarmGroup) {
        return alarmGroupBl.createAlarmGroup(alarmGroup);
    }

    @Override
    public AlarmGroup updateAlarmGroup(int id, AlarmGroup alarmGroup) {
        return alarmGroupBl.updateAlarmGroup(id, alarmGroup);
    }

    @Override
    public AlarmGroup getAlarmGroup(int id) {
        return alarmGroupBl.getAlarmGroup(id);
    }


}
