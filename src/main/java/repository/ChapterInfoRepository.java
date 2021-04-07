package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.ChapterInfo;

@Repository
public interface ChapterInfoRepository extends JpaRepository<ChapterInfo, Integer> {
	
	ChapterInfo findById(Long id);

}
