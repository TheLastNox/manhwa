package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Chapter;
import entity.ManhwaInfo;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer>{
	
	List<Chapter> findByChapterInfoManhwaInfoId(Long id);
	List<Chapter> findByManhwaInfoAndChapterInfoChapterNumber(ManhwaInfo manhwaInfo, Long chapterNumber);
}
