package com.ride.springframework.domain;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
public class Post {
@Id
@GeneratedValue
	private Integer Id;
   @NotEmpty
	private String postText;
	private String postType;
	private Date dateCreated;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private User user;
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post() {
	}

	public List<Comment> getComments() {
		List<Comment>commentList=new ArrayList<>();
		for(Comment c:comments){
			Comment c1=new Comment();
			c1.setComment(c.getComment());
			commentList.add(c1);
		}
		return commentList;
	}


	public void setComments(List<Comment> comments) {
this.comments=comments;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer postId) {
		this.Id = postId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Post [postId=" + Id + ", postText=" + postText + ", postType=" + postType + ", dateCreated="
				+ dateCreated +", user="  + "]";
	}


}
