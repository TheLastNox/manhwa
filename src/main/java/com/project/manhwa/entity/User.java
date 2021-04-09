package com.project.manhwa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 20)
	@Column(unique = true)
	private String username;
	
	@NotBlank
    @Size(min = 6, max = 40)
	private String password;
	
	@NotBlank
    @Size(min = 2, max = 40)
	private String name;
	
	@NotBlank
    @Size(min = 2, max = 40)
	private String firstName;
	
	@NotBlank
	@Email
	@Size(max = 50)
	@Column( unique = true )
	private String email;
	
	@NotBlank
	private Date birthDate;
	
	@Size(max = 140)
	private String bio;
	
	@NotBlank
	private boolean isAuthor;
	
	@NotBlank
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	

	public User(@NotBlank String username, @NotBlank String password, @NotBlank String name,
			@NotBlank String firstName, @NotBlank @Email String email, @NotBlank Date birthDate, String bio,
			@NotBlank boolean isAuthor) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.birthDate = birthDate;
		this.bio = bio;
		this.isAuthor = isAuthor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean isAuthor() {
		return isAuthor;
	}

	public void setAuthor(boolean isAuthor) {
		this.isAuthor = isAuthor;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
