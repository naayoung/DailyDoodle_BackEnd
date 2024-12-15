package com.dailydoodle.tag.service;

import java.util.List;
import java.util.Optional;

import com.dailydoodle.tag.entity.TagsEntity;

public interface TagService {
	// diaryNo에 연결된 태그 목록
	List<String> getTagsByDiary(Integer diaryNo);

	Optional<TagsEntity> getTagById(Integer tagNo);
}
