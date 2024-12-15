package com.dailydoodle.diary.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"memberNo", "moodNo", "doodleNo", "diaryTagsNo"})
public class DiaryDetailDto {
	private Integer diaryNo;
	private Timestamp diaryDate;
	private String title;
	private String content;
	
	private Integer memberNo;
	
	private Integer moodNo;
	private Integer doodleNo;
	private Integer diaryTagsNo;
}