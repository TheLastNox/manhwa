package com.project.manhwa.controller;

import java.util.List;

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

import com.project.manhwa.entity.Chapter;
import com.project.manhwa.repository.ChapterRepository;

@Controller
@RequestMapping(path="/v1/api")
public class ChapterController {
	@Autowired
	ChapterRepository chapterRepository;
	
	@GetMapping(path="/chapters/manhwaInfo/{id}")
	public @ResponseBody Iterable<Chapter> getChaptersByManhwaInfoId(Long id) {
		return chapterRepository.findByChapterInfoManhwaInfoId(id);
	}
	
	@PostMapping(path="/chapter/add")
	public String addNewPage(@Validated @RequestBody Chapter chapter) {
		List<Chapter> existingChapters = chapterRepository.findByManhwaInfoAndChapterInfoChapterNumber(
				chapter.getManhwaInfo(),
				chapter.getChapterInfo().getChapterNumber());
		if(existingChapters.isEmpty()) {
			chapterRepository.save(chapter);
			return "Le chapitre " + chapter.getChapterInfo().getChapterNumber()
					+ " de " + chapter.getManhwaInfo().getName() +" a été ajouté.";
		}
		return "Impossible d'ajouter le chapitre. Le chapitre "
		+ chapter.getChapterInfo().getChapterNumber() + " existe déjà.";
	}
	
	@PutMapping(path="/chapter/update")
	public String updatePage(@RequestBody Chapter chapter) {
		chapterRepository.save(chapter);
		return "Le chapitre " + chapter.getChapterInfo().getChapterNumber()
				+ " de " + chapter.getManhwaInfo().getName() +" a été mis à jour.";
	}
	
	@DeleteMapping(path="/chapter/update")
	public String deletePage(@PathVariable Integer id) {
		chapterRepository.deleteById(id);
		return "Le chapitre a été supprimé.";
	}
}
