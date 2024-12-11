package com.dailydoodle.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.member.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
