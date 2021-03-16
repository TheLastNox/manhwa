package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Genre {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	@NotNull
	private String name;
}
