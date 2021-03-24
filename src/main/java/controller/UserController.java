package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDao;
import model.User;

@Controller
@RequestMapping(path="/v1/api")
public class UserController {
	@Autowired
	UserDao userDao;
	
	@GetMapping(path="/user/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@GetMapping(value = "/user/id/{id}")
	public User getUserById(@PathVariable Long id) {
		return userDao.findById(id);
	}
	
	@GetMapping(value = "/user/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userDao.findByUsername(username);
	}
	
	@GetMapping(value = "/user/username/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userDao.findByEmail(email);
	}
	
	@PostMapping(path="/user/add")
	public String addNewReader(@Validated @RequestBody User user) {
		userDao.save(user);
		return "L'utilisateur " + user.getUsername() + " a été ajouté.";
	}
	
	@PutMapping (value = "/user/update")
	public String updateReader(@RequestBody User user) {
		userDao.save(user);
		return "L'utilisateur "+ user.getUsername()+ " a été mis à jour.";
	}
	
	@DeleteMapping (value = "/user/{id}")
	public String deleteUserById(@PathVariable Integer id) {
		userDao.deleteById(id);
		return "L'utilisateur a été supprimé.";
	}
}