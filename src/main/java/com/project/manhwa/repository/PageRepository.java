package com.project.manhwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.ChapterInfo;
import com.project.manhwa.entity.Page;


@Repository
public interface PageRepository extends JpaRepository<Page, Integer>{
	
	List<Page> findByChapterInfoId(Long id);
	List<Page> findByChapterInfoManhwaInfoId(Long id);
	List<Page> findByChapterInfoAndPageNumber(ChapterInfo chapterInfo, Long pageNumber);
}
