package com.dailydoodle.diary.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailydoodle.diary.dto.DiaryDetailDto;
import com.dailydoodle.diary.dto.DiaryDto;
import com.dailydoodle.diary.entity.DiaryEntity;
import com.dailydoodle.diary.service.DiaryService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:3000/","http://localhost/"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {
    private final DiaryService diaryService;  // final 키워드로 불변성 보장
    
	//전체 조회
	@GetMapping("/totalList")
	public ResponseEntity<List<DiaryEntity>> getDiaryInfo(
			@RequestParam("memberNo") Integer memberNo,
			@RequestParam("moodNo") Integer moodNo,
			@RequestParam("doodleNo") Integer doodleNo,
			@RequestParam("diaryTagsNo") Integer diaryTagsNo){
		
		List<DiaryEntity> list = diaryService.getDiaryInfo(memberNo, moodNo, doodleNo, diaryTagsNo);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	//일부 조회
	@GetMapping("list/{diaryNo}")
	public ResponseEntity<DiaryDetailDto> getdetail(
			@PathVariable Integer diaryNo) {
		DiaryDetailDto diaryDetailDto = diaryService.getDiaryInfoByDate(diaryNo);
        return ResponseEntity.status(HttpStatus.OK).body(diaryDetailDto);
	}

	//등록
    @PostMapping("register")
    public ResponseEntity<Map<String, Object>> getregister(@RequestBody DiaryDetailDto diaryDetailDto) {
		Map<String, Object> result = diaryService.registerDiary(diaryDetailDto);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Result", result.get("diaryNo")));
    }
	
	//수정
    @PutMapping("update/{diaryNo}")
    public ResponseEntity<Map<String, Object>> getmodify(
    		@RequestBody DiaryDetailDto diaryDetailDto,
    		@PathVariable Integer diaryNo) {
    	
    	diaryDetailDto.setDiaryNo(diaryNo);
        diaryService.modifyDiary(diaryDetailDto);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Result", "Success"));
    }
    
    //삭제
    @DeleteMapping("delete/{diaryNo}")
    public ResponseEntity<Map<String, Object>> getdelete(@PathVariable Integer diaryNo) {
        diaryService.deleteDiary(diaryNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("Result", "Success"));
    }
}
