package com.ride.springframework.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty
	private String comment;
	private Date dateCreated;
	private Date dateUpdated;
	@ManyToOne
	private Post post;
	@ManyToOne
	private User user;

	public Comment() {

	}

	public Post getPost() {
		return post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		String space = "  \n .";
		return String.format("%s \n %s \n ", comment, space);
	}
}