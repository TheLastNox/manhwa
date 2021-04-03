package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Manhwa {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@Column( unique = true )
	private String name;
	
	@NotNull
	private String author; // username
	
	@NotNull
	private Genre genre;
	
	@NotNull
	private String summary;
	
	@NotNull
	private Date relDate;
	
	@NotNull
	@OneToMany
	private List<Chapter> chapters;
	
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

	public Genre getGenre() {
		return genre;
	}

	public String getSummary() {
		return summary;
	}

	public Date getRelDate() {
		return relDate;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public Long getViews() {
		return views;
	}

	public Long getFavorites() {
		return favorites;
	}
}
