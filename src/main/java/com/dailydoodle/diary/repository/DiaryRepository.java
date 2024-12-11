package com.dailydoodle.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.diary.entity.DiaryEntity;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer> {

}
