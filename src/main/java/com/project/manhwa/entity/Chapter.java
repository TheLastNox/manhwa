package com.project.manhwa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotBlank;

@Entity
public class Chapter {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	@ManyToOne
	ManhwaInfo manhwaInfo;
	
	@NotBlank
	@OneToOne
	ChapterInfo chapterInfo;
	
	@NotBlank
	@OrderBy("pageNumber ASC")
	@OneToMany( targetEntity=Page.class, mappedBy="chapterInfo" )
	List<Page> pages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ManhwaInfo getManhwaInfo() {
		return manhwaInfo;
	}

	public void setManhwaInfo(ManhwaInfo manhwaInfo) {
		this.manhwaInfo = manhwaInfo;
	}

	public ChapterInfo getChapterInfo() {
		return chapterInfo;
	}

	public void setChapterInfo(ChapterInfo chapterInfo) {
		this.chapterInfo = chapterInfo;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
}
