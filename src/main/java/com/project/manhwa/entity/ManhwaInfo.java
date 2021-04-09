package com.project.manhwa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class ManhwaInfo {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	@Column( unique = true )
	private String name;
	
	@NotBlank
	private String author; // username
	
	@NotBlank
	@OneToMany
	private List<Genre> genres;
	
	@NotBlank
	private String summary;
	
	@NotBlank
	private Date relDate;
	
	private Long views;
	
	private Long favorites;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public String getSummary() {
		return summary;
	}

	public Date getRelDate() {
		return relDate;
	}

	public Long getViews() {
		return views;
	}

	public Long getFavorites() {
		return favorites;
	}
}
