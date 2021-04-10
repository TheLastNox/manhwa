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

import com.project.manhwa.entity.FavoriteManhwas;
import com.project.manhwa.repository.FavoriteManhwasRepository;

@Controller
@RequestMapping(path="/v1/api")
public class FavoriteManhwasController {
	@Autowired
	FavoriteManhwasRepository favoriteManhwasRepository;
	
	@GetMapping(path="/favoriteManhwas/user/id/{id}")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public @ResponseBody Optional<FavoriteManhwas> getFavoriteManhwasByUserId(Long id) {
		return favoriteManhwasRepository.findByUserId(id);
	}
	
	@GetMapping(path="/favoriteManhwas/user/username/{username}")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public @ResponseBody Optional<FavoriteManhwas> getFavoriteManhwasByUserUsername(String username) {
		return favoriteManhwasRepository.findByUserUsername(username);
	}
	
	@PostMapping(path="/favoriteManhwas/add")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public String addNewfavoriteManhwas(@Validated @RequestBody FavoriteManhwas favoriteManhwas) {
		favoriteManhwasRepository.save(favoriteManhwas);
		return "Manhwa ajouté au favoris.";
	}
	
	@PutMapping(value = "/favoriteManhwas/update")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public String updatefavoriteManhwas(@RequestBody FavoriteManhwas favoriteManhwas) {
		favoriteManhwasRepository.save(favoriteManhwas);
		return "Manhwa favoris mis à jour.";
	}
	
	@DeleteMapping(value = "/favoriteManhwas/{id}")
	@PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
	public String deletefavoriteManhwasById(@PathVariable Integer id) {
		favoriteManhwasRepository.deleteById(id);
		return "Manhwa supprimé des favoris.";
	}
}
