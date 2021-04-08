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
	
	@PostMapping(path="/favoriteGenres/add")
	public String addNewfavoriteGenres(@Validated @RequestBody FavoriteGenres favoriteGenres) {
		favoriteGenresRepository.save(favoriteGenres);
		return "Genre ajouté au favoris.";
	}
	
	@PutMapping(value = "/favoriteGenres/update")
	public String updatefavoriteGenres(@RequestBody FavoriteGenres favoriteGenres) {
		favoriteGenresRepository.save(favoriteGenres);
		return "Genre favoris mis à jour.";
	}
	
	@DeleteMapping(value = "/favoriteGenres/{id}")
	public String deletefavoriteGenresById(@PathVariable Integer id) {
		favoriteGenresRepository.deleteById(id);
		return "Genre supprimé des favoris.";
	}
}
