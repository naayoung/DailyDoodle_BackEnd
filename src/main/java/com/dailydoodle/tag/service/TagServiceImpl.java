package com.dailydoodle.tag.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dailydoodle.tag.entity.DiaryTagsEntity;
import com.dailydoodle.tag.entity.TagsEntity;
import com.dailydoodle.tag.repository.DiaryTagsRepository;
import com.dailydoodle.tag.repository.TagsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
	private final DiaryTagsRepository diaryTagsRepo;
	private final TagsRepository tagsRepo;
	
    // diaryNo에 연결된 태그 이름들 반환
    public List<String> getTagsByDiary(Integer diaryNo) {
        List<DiaryTagsEntity> diaryTagsEntities = diaryTagsRepo.findByDiaryEntityDiaryNo(diaryNo);
        return extractTagNames(diaryTagsEntities);
    }

    // diaryTagsEntity 리스트에서 태그 이름만 추출하는 메서드
    private List<String> extractTagNames(List<DiaryTagsEntity> diaryTagsEntities) {
        return diaryTagsEntities.stream()
                .map(diaryTagsEntity -> diaryTagsEntity.getTagsEntity().getTagName())
                .collect(Collectors.toList());
    }
    
    public Optional<TagsEntity> getTagById(Integer tagNo) {
        return tagsRepo.findById(tagNo);
    }
}
