package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Manhwa {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	@NotNull
	@Column(unique = true)
	private String name;
	@NotNull
	private String author; //username
	@NotNull
	private String relDate;
	@NotNull
	private Genre genre;
	

}
