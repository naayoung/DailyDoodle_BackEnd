package com.dailydoodle.member.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
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
@Table(name="tb_member")
@EqualsAndHashCode(of="memberNo")
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberNo;
	@Column(length = 30)
	private String memberId;
	private String memberPwd;
	@Column(length = 20)
	private String memberName;
	@Column(length = 100)
	private String email;
	@Column(length = 13)
	private String phone;
	@Column(length = 20)
	private String nickname;
	private String address1;
	private String address2;
	@Column(length = 5)
	private String zipcode;
	@CreationTimestamp
	private Timestamp created_at;
	private Integer role;
}
	