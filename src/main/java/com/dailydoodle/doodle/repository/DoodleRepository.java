package com.dailydoodle.doodle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.doodle.entity.DiaryDoodleEntity;

public interface DoodleRepository extends JpaRepository<DiaryDoodleEntity, Integer> {

}
