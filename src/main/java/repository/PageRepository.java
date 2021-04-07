package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.ChapterInfo;
import entity.Page;


@Repository
public interface PageRepository extends JpaRepository<Page, Integer>{
	Page findById(Long id);
	List<Page> findByChapterInfoId(Long id);
	List<Page> findByChapterInfoManhwaInfoId(Long id);
	List<Page> findByChapterInfoAndPageNumber(ChapterInfo chapterInfo, Long pageNumber);
}
