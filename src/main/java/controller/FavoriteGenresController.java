package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.FavoriteGenres;
import repository.FavoriteGenresRepository;

@Controller
@RequestMapping(path="/v1/api")
public class FavoriteGenresController  {
	@Autowired
	FavoriteGenresRepository favoriteGenresRepository;
	
	@GetMapping(path="/favoriteGenres/user/id/{id}")
	public @ResponseBody FavoriteGenres getFavoriteGenresByUserId(Long id) {
		return favoriteGenresRepository.findByUserId(id);
	}
	
	@GetMapping(path="/favoriteGenres/user/username/{username}")
	public @ResponseBody FavoriteGenres getFavoriteGenresByUserUsername(String username) {
		return favoriteGenresRepository.findByUserUsername(username);
	}
}
