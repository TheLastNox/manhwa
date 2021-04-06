package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

@Entity
public class Chapter {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@ManyToOne
	ChapterInfo manhwaInfo;
	
	@NotNull
	@OneToOne
	ChapterInfo chapterInfo;
	
	@NotNull
	@OrderBy("pageNumber ASC")
	@OneToMany( targetEntity=Page.class, mappedBy="chapterInfo" )
	List<Page> pages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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