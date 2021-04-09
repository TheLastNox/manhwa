package com.project.manhwa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotBlank;

@Entity
public class Manhwa {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	@OneToOne
	private ManhwaInfo manhwaInfo;
	
	@NotBlank
	@OneToMany
	@OrderBy("chapterInfo.chapterNumber ASC")
	private List<Chapter> chapters;

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

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
}
