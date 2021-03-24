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
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@Column(unique = true)
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String name;
	
	@NotNull
	private String firstName;
	
	@NotNull
	@Column( unique = true )
	@Email
	private String email;
	
	@NotNull
	private Date birthDate;
	
	private String bio;
	
	@NotNull
	private boolean isAuthor;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getBio() {
		return bio;
	}

	public boolean isAuthor() {
		return isAuthor;
	}
}
