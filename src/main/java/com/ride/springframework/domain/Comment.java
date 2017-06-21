package com.ride.springframework.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Integer Id;
	private String comment;
	private LocalDate dateCreated;
	private LocalDate dateUpdated;
	@ManyToOne
	private Post post;
@ManyToOne
private User user;

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
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public Comment() {
	}

	public Post getPost_id() {
		return post;
	}

	public void setPost_id(Post post_id) {
		this.post = post_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDate dateUpdated) {
		this.dateUpdated = dateUpdated;
	}


	@Override
	public String toString() {
		return "Comment [commentId=" + Id + ", comment=" + comment + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated   + "]";
	}
	
}
