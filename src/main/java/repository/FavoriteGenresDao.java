package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.FavoriteGenres;

@Repository
public interface FavoriteGenresDao extends JpaRepository<FavoriteGenres, Integer> {
	
	FavoriteGenres findById(Long id);
	FavoriteGenres findByUserId(Long id);
	FavoriteGenres findByUserUsername(String username);
}
