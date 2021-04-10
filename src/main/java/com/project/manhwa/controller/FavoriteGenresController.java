package com.project.manhwa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.project.manhwa.entity.FavoriteGenres;
import com.project.manhwa.repository.FavoriteGenresRepository;

@Controller
@RequestMapping(path="/v1/api")
public class FavoriteGenresController  {
	@Autowired
	FavoriteGenresRepository favoriteGenresRepository;
	
	@GetMapping(path="/favoriteGenres/user/id/{id}")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public @ResponseBody Optional<FavoriteGenres> getFavoriteGenresByUserId(Long id) {
		return favoriteGenresRepository.findByUserId(id);
	}
	
	@GetMapping(path="/favoriteGenres/user/username/{username}")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public @ResponseBody Optional<FavoriteGenres> getFavoriteGenresByUserUsername(String username) {
		return favoriteGenresRepository.findByUserUsername(username);
	}
	
	@PostMapping(path="/favoriteGenres/add")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public String addNewfavoriteGenres(@Validated @RequestBody FavoriteGenres favoriteGenres) {
		favoriteGenresRepository.save(favoriteGenres);
		return "Genre ajouté au favoris.";
	}
	
	@PutMapping(value = "/favoriteGenres/update")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public String updatefavoriteGenres(@RequestBody FavoriteGenres favoriteGenres) {
		favoriteGenresRepository.save(favoriteGenres);
		return "Genre favoris mis à jour.";
	}
	
	@DeleteMapping(value = "/favoriteGenres/{id}")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public String deletefavoriteGenresById(@PathVariable Integer id) {
		favoriteGenresRepository.deleteById(id);
		return "Genre supprimé des favoris.";
	}
}
