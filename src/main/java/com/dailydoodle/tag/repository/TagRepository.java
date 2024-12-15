package com.dailydoodle.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.tag.entity.DiaryTagsEntity;

public interface TagRepository extends JpaRepository<DiaryTagsEntity, Integer> {
	List<DiaryTagsEntity> findByDiaryEntityDiaryNo(Integer diaryNo);
}
