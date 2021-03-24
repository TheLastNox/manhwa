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

@Entity @Table( name = "FavoriteManhwas")
public class UserManhwa {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne
	private User user; // Un utilisateur peut être lié à plusieurs Manhwa
	
	@OrderBy("name ASC")
	@OneToMany( targetEntity=Manhwa.class, mappedBy="user" )
	private List<Manhwa> manhwas; // Plusieurs Manhwa peuvent être liés à un utilisateur
}
