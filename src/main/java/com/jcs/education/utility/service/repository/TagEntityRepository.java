package com.jcs.education.utility.service.repository;

import com.jcs.education.utility.service.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagEntityRepository extends JpaRepository<TagEntity, Integer> {
}
