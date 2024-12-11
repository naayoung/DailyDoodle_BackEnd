package com.dailydoodle.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.tag.entity.DiaryTagsEntity;

public interface TagRepository extends JpaRepository<DiaryTagsEntity, Integer> {

}
