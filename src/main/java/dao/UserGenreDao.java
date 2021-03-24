package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.UserGenre;

@Repository
public interface UserGenreDao extends JpaRepository<UserGenre, Integer> {
	
	UserGenre findById(Long id);
	UserGenre findByUserId(Long id);
	UserGenre findByUserUsername(String username);
	List<UserGenre> findByGenreId(Long id);
	List<UserGenre> findByGenreName(String name);
}
