package com.project.manhwa.payload.request;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class SignupRequest {
	@NotBlank
    @Size(min = 3, max = 20)
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
    @Size(max = 50)
    @Email
	private String email;
	
	@NotBlank
	private Date birthDate;
	
	@Size(max = 140)
	private String bio;
	
	@NotBlank
	private boolean isAuthor;
	
	@NotBlank
    @Size(min = 6, max = 40)
	private Set<String> role;

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

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
}
