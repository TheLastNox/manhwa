package com.project.manhwa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	@Column( unique = true )
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
