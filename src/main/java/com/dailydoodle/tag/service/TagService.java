package com.dailydoodle.tag.service;

import java.util.List;

public interface TagService {
	// diaryNo에 연결된 태그 목록
	List<String> getTagsByDiary(Integer diaryNo);
}
