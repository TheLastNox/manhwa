package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

@Entity
public class FavoriteManhwas {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@ManyToOne
	private User user; // Un utilisateur peut avoir plusieurs Manhwa favoris
	
	@NotNull
	@OrderBy("manhwaInfo.title ASC")
	@OneToMany
	private List<Manhwa> manhwas; // Plusieurs Manhwa peuvent être le favori d'un utilisateur

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Manhwa> getManhwas() {
		return manhwas;
	}

	public void setManhwas(List<Manhwa> manhwas) {
		this.manhwas = manhwas;
	}
}
