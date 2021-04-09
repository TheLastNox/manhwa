package com.project.manhwa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.manhwa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findById(Long id);
	Optional<User>  findByUsername(String username);
	Optional<User>  findByEmail(String email);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
