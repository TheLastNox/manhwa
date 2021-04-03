package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

@Entity
public class Chapter {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	private String title;
	
	@OrderBy("name ASC")
	@OneToMany
	private List<Page> pages;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<Page> getPages() {
		return pages;
	}
}
