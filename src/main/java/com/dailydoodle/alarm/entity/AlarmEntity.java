package com.dailydoodle.alarm.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.dailydoodle.member.entity.MemberEntity;

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
@Table(name="tb_alarm")
@EqualsAndHashCode(of="alarmNo")
public class AlarmEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer alarmNo;
	private Integer type;
	private Boolean isRead;
	@CreationTimestamp
	private Timestamp createdAt;

	@ManyToOne
	@JoinColumn(name = "member_no")
	private MemberEntity memberEntity;
}
