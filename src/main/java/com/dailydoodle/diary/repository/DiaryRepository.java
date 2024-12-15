package com.dailydoodle.diary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dailydoodle.diary.entity.DiaryEntity;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer> {
	//일기 목록
	List<DiaryEntity> findByMemberEntityMemberNoAndMoodEntityMoodNoAndDiaryDoodleEntityDoodleNoOrderByRegisterDateDesc(Integer memberNo, Integer moodNo, Integer doodleNo);
	//일기 세부 목록
    @Query("SELECT d FROM DiaryEntity d " +
            "WHERE d.memberEntity.memberNo = :memberNo " +
            "AND d.moodEntity.moodNo = :moodNo " +
            "AND d.diaryDoodleEntity.doodleNo = :doodleNo " +
            "AND d.diaryTagsEntity.diaryTagsNo = :diaryTagsNo " +
            "AND date_format(d.diaryDate,'%Y-%m-%d') = :diaryDate")
    List<DiaryEntity> getDiaryInfoByDate(Integer memberNo, Integer moodNo, Integer doodleNo, Integer diaryTagsNo, String diaryDate);
	
	//diaryNo로 정보 불러오기
	List<DiaryEntity> findByDiaryNo(Integer diaryNo);
}
