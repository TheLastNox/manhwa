package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.ChapterInfo;
import repository.ChapterInfoRepository;

@Controller
@RequestMapping(path="/v1/api")
public class ChapterInfoController {
	@Autowired
	ChapterInfoRepository chapterInfoRepository;
	
	@GetMapping(path="/genre/all")
	public @ResponseBody Iterable<ChapterInfo> getAllChapterInfo() {
		return chapterInfoRepository.findAll();
	}
	
	@GetMapping(path="/genre/id/{id}")
	public @ResponseBody ChapterInfo getChapterInfoById(Long id) {
		return chapterInfoRepository.findById(id);
	}
}
