package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Genre;
import entity.Manhwa;

@Repository
public interface ManhwaRepository extends JpaRepository<Manhwa, Integer> {
	
	Manhwa findById(Long id);
	Manhwa findByManhwaInfoName(String name);
	List<Manhwa> findByManhwaInfoGenres(Genre ...genre);
	
}
