package com.project.manhwa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.FavoriteGenres;

@Repository
public interface FavoriteGenresRepository extends JpaRepository<FavoriteGenres, Integer> {
	
	Optional<FavoriteGenres> findByUserId(Long id);
	Optional<FavoriteGenres> findByUserUsername(String username);
}
