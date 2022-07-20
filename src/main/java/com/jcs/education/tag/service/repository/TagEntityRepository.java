package com.jcs.education.tag.service.repository;

import com.jcs.education.tag.service.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagEntityRepository extends JpaRepository<TagEntity, Integer> {
}
