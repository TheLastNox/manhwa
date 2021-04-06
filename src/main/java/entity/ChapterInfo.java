package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ChapterInfo {

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	private Long chapterNumber;
	
	@NotNull
	private String title;
	
	@NotNull
	@ManyToOne
	ManhwaInfo manhwaInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(Long chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ManhwaInfo getManhwaInfo() {
		return manhwaInfo;
	}

	public void setManhwaInfo(ManhwaInfo manhwaInfo) {
		this.manhwaInfo = manhwaInfo;
	}
}
