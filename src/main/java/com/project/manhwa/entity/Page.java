package com.project.manhwa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Page {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	private Long pageNumber;
	
	@NotBlank
	private String content;
	
	@NotBlank
	@ManyToOne
	ChapterInfo chapterInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ChapterInfo getChapterInfo() {
		return chapterInfo;
	}

	public void setChapterInfo(ChapterInfo chapterInfo) {
		this.chapterInfo = chapterInfo;
	}
}
