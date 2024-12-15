package com.dailydoodle.tag.entity;

import com.dailydoodle.diary.entity.DiaryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_diary_tags")
@EqualsAndHashCode(of="diaryTagsNo")
public class DiaryTagsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer diaryTagsNo;
	
	@ManyToOne
	@JoinColumn(name = "diary_no")
	private DiaryEntity diaryEntity;
	
	@ManyToOne
	@JoinColumn(name = "tag_no")
	private TagsEntity tagsEntity;
}
