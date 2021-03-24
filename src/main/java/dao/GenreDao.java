package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Genre;

@Repository
public interface GenreDao extends JpaRepository<Genre, Integer> {
	
	Genre findById(Long id);
	Genre findByName(String name);
}
