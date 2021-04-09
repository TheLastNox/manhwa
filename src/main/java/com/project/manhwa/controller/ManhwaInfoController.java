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
import com.project.manhwa.entity.ManhwaInfo;
import com.project.manhwa.repository.ManhwaInfoRepository;

@Controller
@RequestMapping(path="/v1/api")
public class ManhwaInfoController {
	@Autowired
	ManhwaInfoRepository manhwaInfoRepository;
	
	@GetMapping(path="/manhwaInfo/id/")
	public @ResponseBody ManhwaInfo getManhwaById(Long id) {
		return manhwaInfoRepository.findById(id);
	}
	
	@GetMapping(path="/manhwaInfo/name/")
	public @ResponseBody ManhwaInfo getManhwaByName(String name) {
		return manhwaInfoRepository.findByName(name);
	}
	
	@GetMapping(path="/manhwaInfo/author/{author}")
	public @ResponseBody Iterable<ManhwaInfo> getManhwaByAuthor(String author) {
		return manhwaInfoRepository.findByAuthor(author);
	}
	
	@GetMapping(path="/manhwaInfo/genres/{genres}")
	public @ResponseBody Iterable<ManhwaInfo> getManhwaByGenres(Genre ...genre) {
		return manhwaInfoRepository.findByGenres(genre);
	}
	
	@PostMapping(path="/manhwaInfo/add")
	public String addNewmanhwaInfo(@Validated @RequestBody ManhwaInfo manhwaInfo) {
		manhwaInfoRepository.save(manhwaInfo);
		return "L'entête manhwa " + manhwaInfo.getName() + " a été ajouté.";
	}
	
	@PutMapping(value = "/manhwaInfo/update")
	public String updatemanhwaInfo(@RequestBody ManhwaInfo manhwaInfo) {
		manhwaInfoRepository.save(manhwaInfo);
		return "L'entête manhwa " + manhwaInfo.getName() + " a été mis à jour.";
	}
	
	@DeleteMapping(value = "/manhwaInfo/{id}")
	public String deletemanhwaInfoById(@PathVariable Integer id) {
		manhwaInfoRepository.deleteById(id);
		return "L'entête manhwa a été supprimé.";
	}
}
