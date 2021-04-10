package com.project.manhwa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.FavoriteManhwas;

@Repository
public interface FavoriteManhwasRepository extends JpaRepository<FavoriteManhwas, Integer> {
	
	Optional<FavoriteManhwas> findById(Long id);
	Optional<FavoriteManhwas> findByUserId(Long id);
	Optional<FavoriteManhwas> findByUserUsername(String username);
}
