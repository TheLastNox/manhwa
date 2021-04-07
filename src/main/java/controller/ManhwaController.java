package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Genre;
import entity.Manhwa;
import repository.ManhwaRepository;

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
}
