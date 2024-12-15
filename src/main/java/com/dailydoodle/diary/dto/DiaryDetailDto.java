package com.dailydoodle.diary.dto;

import java.sql.Timestamp;
import java.util.List;

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
	private Timestamp updateDate;
	
	private Integer memberNo;
	
	private Integer moodNo;
	private Integer mood;
	private String imageUrl;
	
	private Integer doodleNo;
	private String doodleSrc;
	
	private Integer diaryTagsNo;
	private List<String> tags;
}