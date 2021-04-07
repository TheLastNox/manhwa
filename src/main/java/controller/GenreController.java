package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Genre;
import repository.GenreRepository;

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
}
