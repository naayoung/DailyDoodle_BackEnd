package com.dailydoodle.diary.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = {"http://localhost:3000/","http://localhost/"})
@RestController
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
    private DiaryService diaryService;
	
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
	public ResponseEntity<List<DiaryDetailDto>> getdetail(
			@PathVariable Integer diaryNo) {
		List<DiaryDetailDto> list = diaryService.getDiaryInfoByDate(diaryNo);
        return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	//등록
    @PostMapping("register")
    public ResponseEntity<Map<String, Object>> getregister(@RequestBody DiaryDto diaryDto) {
		Map<String, Object> result = diaryService.registerDiary(diaryDto);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Result", result.get("diaryNo")));
    }
	
	//수정
    @PutMapping("update/{diaryNo}")
    public ResponseEntity<Map<String, Object>> getmodify(
    		@RequestBody DiaryDto diaryDto,
    		@PathVariable Integer diaryNo) {
    	
    	diaryDto.setDiaryNo(diaryNo);
        diaryService.modifyDiary(diaryDto);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Result", "Success"));
    }
    
    //삭제
    @DeleteMapping("delete/{diaryNo}")
    public ResponseEntity<Map<String, Object>> getdelete(@PathVariable Integer diaryNo) {
        diaryService.deleteDiary(diaryNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("Result", "Success"));
    }
}
