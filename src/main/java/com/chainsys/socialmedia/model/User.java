package com.chainsys.socialmedia.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userid")
    @SequenceGenerator(name = "userid", sequenceName = "userid",  allocationSize = 1)
	@Column(name="userid")
	private int userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pasword")
	private String password;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="country")
	private String country;
	
	@Column(name="joiningdate")
	private Date joiningDate;

	@Column(name="gender")
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
