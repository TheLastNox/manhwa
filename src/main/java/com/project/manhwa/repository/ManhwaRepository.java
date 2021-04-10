package com.project.manhwa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.Genre;
import com.project.manhwa.entity.Manhwa;

@Repository
public interface ManhwaRepository extends JpaRepository<Manhwa, Integer> {
	
	Optional<Manhwa> findById(Long id);
	Optional<Manhwa> findByManhwaInfoName(String name);
	List<Manhwa> findByManhwaInfoGenres(Genre ...genre);
	
}
