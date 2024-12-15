package com.dailydoodle.diary.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dailydoodle.diary.dto.DiaryDetailDto;
import com.dailydoodle.diary.dto.DiaryDto;
import com.dailydoodle.diary.entity.DiaryEntity;
import com.dailydoodle.diary.entity.MoodEntity;
import com.dailydoodle.diary.repository.DiaryRepository;
import com.dailydoodle.doodle.entity.DiaryDoodleEntity;
import com.dailydoodle.doodle.service.DoodleService;
import com.dailydoodle.member.entity.MemberEntity;
import com.dailydoodle.tag.entity.DiaryTagsEntity;
import com.dailydoodle.tag.service.TagService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DiaryServiceImpl implements DiaryService {
	private final DiaryRepository diaryRepo;
	private final DoodleService doodleService;
	private final TagService tagService;

    //일기 리스트
    @Override
    public List<DiaryEntity> getDiaryInfo(Integer memberNo, Integer moodNo, Integer doodleNo,Integer diaryTagsNo) {
        return diaryRepo.findByMemberEntityMemberNoAndMoodEntityMoodNoAndDiaryDoodleEntityDoodleNoAndDiaryTagsEntityDiaryTagsNoOrderByRegisterDateDesc(memberNo, moodNo, doodleNo, diaryTagsNo);
    }
    
    //날짜 조건있는 일기 정보
    @Override
    public DiaryDetailDto getDiaryInfoByDate(Integer diaryNo){
    	Optional<DiaryEntity> diaryEntityOptional = diaryRepo.findById(diaryNo);
    	
    	if (diaryEntityOptional.isPresent()) {
    		DiaryEntity diaryEntity = diaryEntityOptional.get();
    		
            // DiaryDetailDto 생성 및 값 설정
            DiaryDetailDto diaryDetailDto = new DiaryDetailDto();
            diaryDetailDto.setDiaryNo(diaryNo);
            diaryDetailDto.setDiaryDate(diaryEntity.getDiaryDate());
            diaryDetailDto.setTitle(diaryEntity.getTitle());
            diaryDetailDto.setContent(diaryEntity.getContent());
            diaryDetailDto.setUpdateDate(diaryEntity.getUpdateDate());
            
            diaryDetailDto.setMemberNo(diaryEntity.getMemberEntity().getMemberNo());
            
            // Mood 정보 설정
            diaryDetailDto.setMoodNo(diaryEntity.getMoodEntity().getMoodNo());
            diaryDetailDto.setMood(diaryEntity.getMoodEntity().getMood());
            diaryDetailDto.setImageUrl(diaryEntity.getMoodEntity().getImageUrl());
            
            // Doodle 정보 설정
            diaryDetailDto.setDoodleNo(diaryEntity.getDiaryDoodleEntity().getDoodleNo());
            diaryDetailDto.setDoodleSrc(diaryEntity.getDiaryDoodleEntity().getDoodleSrc());
            
            // Tags 정보 설정
            List<String> tags = tagService.getTagsByDiary(diaryNo);
            diaryDetailDto.setTags(tags);
            
            return diaryDetailDto;
        } else {
            throw new RuntimeException("해당 일기를 찾을 수 없습니다. diaryNo: "+ diaryNo);
        }
    }
    
    //일기 등록
    @Override
    @Transactional
    public Map<String, Object> registerDiary(DiaryDto diaryDto) {
    	
    	// 날짜 파싱
        Timestamp diaryDate = diaryDto.getDiaryDate();

        // MemberEntity, MoodEntity, DiaryDoodleEntity, TagsEntity 생성
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberNo(diaryDto.getMemberNo());

        MoodEntity moodEntity = new MoodEntity();
        moodEntity.setMoodNo(diaryDto.getMoodNo());
        
        DiaryDoodleEntity doodleEntity = new DiaryDoodleEntity();
        doodleEntity.setDoodleNo(diaryDto.getDoodleNo());
        
        DiaryTagsEntity tagsEntity = new DiaryTagsEntity();
        tagsEntity.setDiaryTagsNo(diaryDto.getDiaryTagsNo());

        // DiaryEntity 생성
        DiaryEntity diaryEntity = new DiaryEntity();
        diaryEntity.setMemberEntity(memberEntity);
        diaryEntity.setMoodEntity(moodEntity);
        diaryEntity.setDiaryDoodleEntity(doodleEntity);
        diaryEntity.setDiaryTagsEntity(tagsEntity);
        
        diaryEntity.setDiaryDate(diaryDate);
        diaryEntity.setTitle(diaryDto.getTitle());
        diaryEntity.setContent(diaryDto.getContent());

        diaryRepo.save(diaryEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("diaryNo", diaryEntity.getDiaryNo());
        return result;
    }
    
    //일기 수정
    @Override
    @Transactional
    public void modifyDiary(DiaryDto diaryDto) {
    	Optional<DiaryEntity> modifyDiary = diaryRepo.findById(diaryDto.getDiaryNo());
    	
        if (modifyDiary.isPresent()) {
            DiaryEntity existingDiary = modifyDiary.get();
            existingDiary.setTitle(diaryDto.getTitle());
            existingDiary.setContent(diaryDto.getContent());
            
            try {
                diaryRepo.save(existingDiary);
            } catch (Exception e) {
                // 적절한 에러 핸들링
                e.printStackTrace(); // 또는 로깅 등
                throw new RuntimeException("일기 수정 중 오류가 발생했습니다.");
            }
        } else {
            // 일기가 존재하지 않을 경우의 처리
            throw new RuntimeException("해당 일기를 찾을 수 없습니다.");
        }
    }
    
    //일기 삭제
    @Override
    public void deleteDiary(Integer diaryNo) {
        diaryRepo.deleteById(diaryNo);
    }

}
