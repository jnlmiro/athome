package org.jorgma.athome.alarm.business;

import org.jorgma.athome.alarm.dao.AlarmGroupRepository;
import org.jorgma.athome.alarm.domain.AlarmGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-09-07.
 */
@Service
public class AlarmGroupBlImpl implements AlarmGroupBl {

    @Autowired
    private AlarmGroupRepository alarmGroupRepository;

    @Override
    public List<AlarmGroup> getAlarmGroups() {
        return (List<AlarmGroup>) alarmGroupRepository.findAll();
    }

    @Override
    public AlarmGroup createAlarmGroup(AlarmGroup alarmGroup) {
        return alarmGroupRepository.save(alarmGroup);
    }

    @Override
    public AlarmGroup updateAlarmGroup(int id, AlarmGroup alarmGroup) {
        Optional<AlarmGroup> existingAlarmGroup = alarmGroupRepository.findById(id);
        assert existingAlarmGroup.isPresent();
        return alarmGroupRepository.save(alarmGroup);
    }

    @Override
    public AlarmGroup getAlarmGroup(int id) {
        Optional<AlarmGroup> alarmGroup = alarmGroupRepository.findById(id);
        assert alarmGroup.isPresent();
        return alarmGroup.get();
    }
}
