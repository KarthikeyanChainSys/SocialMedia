package com.chainsys.socialmedia.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="userid")
	private int userId;
	
	@Email(message = "*Email is not valid")
	@NotEmpty(message = "*Please enter email")
	private String email;
	
	@Column(name="pasword")
	@Size(max = 20, min = 8, message = "*Password length should be 8 to 20")
	@NotBlank(message = "*Password can't be Empty")
	@Pattern(regexp = "^[A-Za-z]\\w{3,20}$", message = "*Enter valid password ")
	private String pasword;
	
	@Column(name="username")
	@Size(max = 20, min = 3, message = "*Name length should be 3 to 20")
	@NotBlank(message = "*Name can't be Empty")
	@Pattern(regexp = "^[A-Za-z]\\w{3,20}$", message = "*Enter valid name ")
	private String userName;
	
	@NotEmpty(message = "*Please enter DOB")
	@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$", message = "*Value should be in date formate ")
	private Date dob;
	
	@NotEmpty(message = "*Please enter country")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "*Value should be in Alphabets ")
	private String country;
	
	@Column(name="joiningdate")
	@NotEmpty(message = "*Please enter joining date")
	@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$", message = "*Value should be in date formate ")
	private Date joiningDate;
	
	@NotEmpty(message = "*Please enter gender")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "*Value should be in Alphabets ")
	private String gender;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Friend> friend;
	public List<Friend> getFriend() {
		return friend;
	}
	public void setFriend(List<Friend> friend) {
		this.friend = friend;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> post;
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
