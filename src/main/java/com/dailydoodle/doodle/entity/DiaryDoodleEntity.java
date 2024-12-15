package com.dailydoodle.doodle.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.dailydoodle.diary.entity.DiaryEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_diary_doodle")
@EqualsAndHashCode(of="doodleNo")
public class DiaryDoodleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doodleNo;
	private String doodleSrc;
	@Column(length = 5)
	private String doodleExtension;
	@CreationTimestamp
	private Timestamp uploadDate;
	
	@OneToOne(mappedBy = "diaryDoodleEntity", cascade = CascadeType.ALL)
	private DiaryEntity diaryEntity;
}
