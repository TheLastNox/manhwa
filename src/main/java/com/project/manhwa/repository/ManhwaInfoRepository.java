package com.project.manhwa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.Genre;
import com.project.manhwa.entity.ManhwaInfo;

@Repository
public interface ManhwaInfoRepository extends JpaRepository<ManhwaInfo, Integer> {

	ManhwaInfo findById(Long id);
	ManhwaInfo findByName(String name);
	List<ManhwaInfo> findByAuthor(String author);
	List<ManhwaInfo> findByGenres(Genre ...genre);
	List<ManhwaInfo> findByRelDate(Date relDate);
}
