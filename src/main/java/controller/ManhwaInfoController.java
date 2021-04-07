package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Genre;
import entity.ManhwaInfo;
import repository.ManhwaInfoRepository;

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
}
