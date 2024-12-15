package com.dailydoodle.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.diary.entity.MoodEntity;

public interface MoodRepository extends JpaRepository<MoodEntity, Integer> {

}
