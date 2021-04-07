package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.FavoriteManhwas;
import repository.FavoriteManhwasRepository;

@Controller
@RequestMapping(path="/v1/api")
public class FavoriteManhwasController {
	@Autowired
	FavoriteManhwasRepository favoriteManhwasRepository;
	
	@GetMapping(path="/favoriteManhwas/user/id/{id}")
	public @ResponseBody FavoriteManhwas getFavoriteManhwasByUserId(Long id) {
		return favoriteManhwasRepository.findByUserId(id);
	}
	
	@GetMapping(path="/favoriteManhwas/user/username/{username}")
	public @ResponseBody FavoriteManhwas getFavoriteManhwasByUserId(String username) {
		return favoriteManhwasRepository.findByUserUsername(username);
	}
}
