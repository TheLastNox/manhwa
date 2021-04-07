package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Chapter;
import repository.ChapterRepository;

@Controller
@RequestMapping(path="/v1/api")
public class ChapterController {
	@Autowired
	ChapterRepository chapterRepository;
	
	@GetMapping(path="/chapters/manhwaInfo/{id}")
	public @ResponseBody Iterable<Chapter> getChaptersByManhwaInfoId(Long id) {
		return chapterRepository.findByChapterInfoManhwaInfoId(id);
	}
}
