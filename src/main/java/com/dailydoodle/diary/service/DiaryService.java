package com.dailydoodle.diary.service;

import java.util.List;
import java.util.Map;

import com.dailydoodle.diary.dto.DiaryDetailDto;
import com.dailydoodle.diary.dto.DiaryDto;
import com.dailydoodle.diary.entity.DiaryEntity;

public interface DiaryService {
	//전체 목록
	List<DiaryEntity> getDiaryInfo(Integer memberNo, Integer moodNo, Integer doodleNo, Integer tagNo);
	//세부 내역
	DiaryDetailDto getDiaryInfoByDate(Integer diaryNo);
    //등록
    Map<String, Object> registerDiary(DiaryDto diaryDto);
    //수정
    void modifyDiary(DiaryDto diaryDto);
    //삭제
    void deleteDiary(Integer diaryNo);
}
