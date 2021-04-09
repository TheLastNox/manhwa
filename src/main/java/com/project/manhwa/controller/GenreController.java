package com.project.manhwa.controller;

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

import com.project.manhwa.entity.Genre;
import com.project.manhwa.repository.GenreRepository;

@Controller
@RequestMapping(path="/v1/api")
public class GenreController {
	@Autowired
	GenreRepository genreRepository;
	
	@GetMapping(path="/genre/all")
	public @ResponseBody Iterable<Genre> getAllGenres() {
		return genreRepository.findAll();
	}
	
	@GetMapping(path="/genre/id/{id}")
	public @ResponseBody Genre getGenreById(Long id) {
		return genreRepository.findById(id);
	}
	
	@GetMapping(path="/genre/name/{name}")
	public @ResponseBody Genre getGenreById(String name) {
		return genreRepository.findByName(name);
	}
	
	@PostMapping(path="/genre/add")
	public String addNewgenre(@Validated @RequestBody Genre genre) {
		genreRepository.save(genre);
		return "Le genre " + genre.getName() + " a été ajouté.";
	}
	
	@PutMapping(value = "/genre/update")
	public String updategenre(@RequestBody Genre genre) {
		genreRepository.save(genre);
		return "Le genre " + genre.getName() + " a été mis à jour.";
	}
	
	@DeleteMapping(value = "/genre/{id}")
	public String deletegenreById(@PathVariable Integer id) {
		genreRepository.deleteById(id);
		return "Le genre a été supprimé.";
	}
}
