package com.dailydoodle.diary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_mood")
@EqualsAndHashCode(of="moodNo")
public class MoodEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer moodNo;
	private Integer mood;
	private String imageUrl;
}
