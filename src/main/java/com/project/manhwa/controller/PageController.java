package com.project.manhwa.controller;

import java.util.List;

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

import com.project.manhwa.entity.Page;
import com.project.manhwa.repository.PageRepository;

@Controller
@RequestMapping(path="/v1/api")
public class PageController {
	@Autowired
	PageRepository pageRepository;
	
	@GetMapping(path="/pages/chapterInfo/id/{id}")
	public @ResponseBody Iterable<Page> getPagesByChapterInfoId(Long id) {
		return pageRepository.findByChapterInfoId(id);
	}
	
	@GetMapping(path="/pages/manhwaInfo/id/{id}")
	public @ResponseBody Iterable<Page> getPagesByManhwaInfoId(Long id) {
		return pageRepository.findByChapterInfoManhwaInfoId(id);
	}
	
	@PostMapping(path="/page/add")
	@PreAuthorize("hasRole('AUTHOR')")
	public String addNewPage(@Validated @RequestBody Page page) {
		List<Page> existingPages = pageRepository.findByChapterInfoAndPageNumber(
				page.getChapterInfo(),
				page.getPageNumber());
		if(existingPages.isEmpty()) {
			pageRepository.save(page);
			return "La page " + page.getPageNumber() + " a été ajoutée.";
		}
		return "Impossible d'ajouter la page. La page " + page.getPageNumber() + " existe déjà.";
	}
	
	@PutMapping(path="/page/update")
	@PreAuthorize("hasRole('AUTHOR')")
	public String updatePage(@RequestBody Page page) {
		pageRepository.save(page);
		return "La page " + page.getPageNumber() + " a été mis à jour.";
	}
	
	@DeleteMapping(path="/page/{id}")
	@PreAuthorize("hasRole('AUTHOR') or hasRole('ADMIN')")
	public String deletePage(@PathVariable Integer id) {
		pageRepository.deleteById(id);
		return "La page a été supprimée.";
	}
}
