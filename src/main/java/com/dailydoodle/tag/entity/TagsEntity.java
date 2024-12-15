package com.dailydoodle.tag.entity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_tags")
@EqualsAndHashCode(of="tagNo")
public class TagsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tagNo;
	@Column(length = 50)
	private String tagName;
	@CreationTimestamp
	private Timestamp createdAt;
	
	// 객체지향적으로 태그 정보를 가져오기 위해 추가
	@OneToMany(mappedBy = "diaryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DiaryTagsEntity> diaryTagsEntities;
}