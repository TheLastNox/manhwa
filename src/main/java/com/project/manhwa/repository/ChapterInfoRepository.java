package com.project.manhwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.ChapterInfo;

@Repository
public interface ChapterInfoRepository extends JpaRepository<ChapterInfo, Integer> {
	
	ChapterInfo findById(Long id);

}
