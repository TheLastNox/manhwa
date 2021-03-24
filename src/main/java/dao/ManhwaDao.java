package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Genre;
import model.Manhwa;

@Repository
public interface ManhwaDao extends JpaRepository<Manhwa, Integer> {

	Manhwa findById(Long id);
	Manhwa findByName(String name);
	List<Manhwa> findByAuthor(String author);
	List<Manhwa> findByGenre(Genre genre);
	List<Manhwa> findByRelDate(Date relDate);
}
