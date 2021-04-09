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
import com.project.manhwa.entity.Manhwa;
import com.project.manhwa.repository.ManhwaRepository;

@Controller
@RequestMapping(path="/v1/api")
public class ManhwaController {
	@Autowired
	ManhwaRepository manhwaRepository;
	
	@GetMapping(path="/manhwa/all")
	public @ResponseBody Iterable<Manhwa> getAllManhwas() {
		return manhwaRepository.findAll();
	}
	
	@GetMapping(path="/manhwa/id/{id}")
	public @ResponseBody Manhwa getManhwaById(Long id) {
		return manhwaRepository.findById(id);
	}
	
	@GetMapping(path="/manhwa/manhwaInfo/name/{name}")
	public @ResponseBody Manhwa getManhwaByManhwaInfoName(String name) {
		return manhwaRepository.findByManhwaInfoName(name);
	}
	
	@GetMapping(path="/manhwa/manhwaInfo/genres/{genres}")
	public @ResponseBody Iterable<Manhwa> getManhwaByManhwaInfoGenres(Genre ...genre) {
		return manhwaRepository.findByManhwaInfoGenres(genre);
	}
	
	@PostMapping(path="/manhwa/add")
	public String addNewmanhwa(@Validated @RequestBody Manhwa manhwa) {
		manhwaRepository.save(manhwa);
		return "Le manhwa " + manhwa.getManhwaInfo().getName() + " a été ajouté.";
	}
	
	@PutMapping(value = "/manhwa/update")
	public String updatemanhwa(@RequestBody Manhwa manhwa) {
		manhwaRepository.save(manhwa);
		return "Le manhwa " + manhwa.getManhwaInfo().getName() + " a été mis à jour.";
	}
	
	@DeleteMapping(value = "/manhwa/{id}")
	public String deletemanhwaById(@PathVariable Integer id) {
		manhwaRepository.deleteById(id);
		return "Le manhwa a été supprimé.";
	}
}
