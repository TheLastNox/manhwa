package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Page;


@Repository
public interface PageRepository extends JpaRepository<Page, Integer>{
	Page findById(Long id);
	List<Page> findByChapterInfoTitle(String title);
	List<Page> findByChapterInfoManhwaInfoName(String name);
}
