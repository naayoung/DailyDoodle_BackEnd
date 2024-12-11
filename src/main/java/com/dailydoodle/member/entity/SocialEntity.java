package com.dailydoodle.member.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="tb_social")
@EqualsAndHashCode(of="socialNo")
public class SocialEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer socialNo;
	private Integer provider;
	private String providerId;
	private String socialEmail;
	private String profileImage;
	@CreationTimestamp
	private Timestamp createdAt;

	@ManyToOne
	@JoinColumn(name = "member_no")
	private MemberEntity memberEntity;
}
