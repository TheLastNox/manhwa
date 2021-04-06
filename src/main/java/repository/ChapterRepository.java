package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer>{
	
	Chapter findById(Long id);
	List<Chapter> findByChapterInfoManhwaInfoId(Long id);
	List<Chapter> findByChapterInfoManhwaInfoName(String name);
}
