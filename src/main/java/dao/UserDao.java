package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User findById(Long id);
	User findByUsername(String username);
	User findByEmail(String email);
}
