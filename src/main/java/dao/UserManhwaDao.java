package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Genre;
import model.UserManhwa;

@Repository
public interface UserManhwaDao extends JpaRepository<UserManhwa, Integer> {
	
	UserManhwa findById(Long id);
	UserManhwa findByUserId(Long id);
	UserManhwa findByUserUsername(String username);
	List<UserManhwa> findByManhwaId(Long id);
	List<UserManhwa> findByManhwaName(String name);
	List<UserManhwa> findByManhwaAuthor(String author);
	List<UserManhwa> findByManhwaGenre(Genre genre);
	List<UserManhwa> findByManhwaRelDate(Date relDate);
}
