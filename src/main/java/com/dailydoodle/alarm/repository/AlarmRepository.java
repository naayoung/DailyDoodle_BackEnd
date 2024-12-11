package com.dailydoodle.alarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.alarm.entity.AlarmEntity;

public interface AlarmRepository extends JpaRepository<AlarmEntity, Integer> {

}
