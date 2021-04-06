package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Page {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	private Long pageNumber;
	
	@NotNull
	private String content;
	
	@NotNull
	@ManyToOne
	ChapterInfo chapterInfo;

	public Long getId() {
		return id;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public String getContent() {
		return content;
	}
}
