package com.project.manhwa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
	
	Optional<Genre> findById(Long id);
	Optional<Genre> findByName(String name);
}
