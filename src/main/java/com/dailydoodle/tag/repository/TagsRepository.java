package com.dailydoodle.tag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydoodle.tag.entity.TagsEntity;

public interface TagsRepository extends JpaRepository<TagsEntity, Integer> {
	Optional<TagsEntity> findByTagNo(Integer tagNo); 
}
