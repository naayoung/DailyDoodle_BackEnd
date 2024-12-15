package com.dailydoodle.diary.entity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dailydoodle.doodle.entity.DiaryDoodleEntity;
import com.dailydoodle.member.entity.MemberEntity;
import com.dailydoodle.tag.entity.DiaryTagsEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="tb_diary")
@EqualsAndHashCode(of="diaryNo")
public class DiaryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer diaryNo;
	private Timestamp diaryDate;
	@Column(length = 100)
	private String title;
	@Column(length = 1000)
	private String content;
	@CreationTimestamp
	private Timestamp registerDate;
	@UpdateTimestamp
	private Timestamp updateDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "member_no")
	private MemberEntity memberEntity;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mood_no")
	private MoodEntity moodEntity;
	@OneToOne
	@JoinColumn(name = "doolde_no")
	private DiaryDoodleEntity diaryDoodleEntity;
	
	@OneToMany(mappedBy = "diaryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DiaryTagsEntity> diaryTagsEntities;
}
