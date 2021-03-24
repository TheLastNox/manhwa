package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity @Table( name = "FavoriteGenres")
public class UserGenre {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne
	private User user;
	
	@OrderBy("name ASC")
	@OneToMany( targetEntity=Genre.class, mappedBy="user" )
	private List<Genre> genres;
}
