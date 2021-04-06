package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.FavoriteManhwas;

@Repository
public interface FavoriteManhwasDao extends JpaRepository<FavoriteManhwas, Integer> {
	
	FavoriteManhwas findById(Long id);
	FavoriteManhwas findByUserId(Long id);
	FavoriteManhwas findByUserUsername(String username);
}
