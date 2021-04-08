package controller;

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
	
	@PostMapping(path="/chapterInfo/add")
	public String addNewchapterInfo(@Validated @RequestBody ChapterInfo chapterInfo) {
		chapterInfoRepository.save(chapterInfo);
		return "L'entête de chapitre " + chapterInfo.getChapterNumber()
		+ "de" + chapterInfo.getManhwaInfo().getName() + " a été ajouté.";
	}
	
	@PutMapping(value = "/chapterInfo/update")
	public String updatechapterInfo(@RequestBody ChapterInfo chapterInfo) {
		chapterInfoRepository.save(chapterInfo);
		return "L'entête de chapitre " + chapterInfo.getChapterNumber()
		+ "de" + chapterInfo.getManhwaInfo().getName() + " a été mis à jour.";
	}
	
	@DeleteMapping(value = "/chapterInfo/{id}")
	public String deletechapterInfoById(@PathVariable Integer id) {
		chapterInfoRepository.deleteById(id);
		return "L'entête de chapitre a été supprimé.";
	}
}
