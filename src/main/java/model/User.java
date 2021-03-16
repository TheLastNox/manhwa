package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	@NotNull
	@Column(unique = true)
	private String username;
	@NotNull
	private String name;
	@NotNull
	private String firstName;
	private String bio;
	@NotNull
	@Column(unique = true)
	@Email
	private String email;
	@NotNull
	private Date birthDate;
	@NotNull
	private String password;
	@NotNull
	private boolean isAuthor;

}
