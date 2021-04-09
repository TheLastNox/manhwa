package com.project.manhwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
	
	Genre findById(Long id);
	Genre findByName(String name);
}
