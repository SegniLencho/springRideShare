package guru.springframework.domain;

import java.time.LocalDate;

public class Comment {
	private String commentId;
	private String comment;
	private LocalDate dateCreated;
	private LocalDate dateUpdated;
	
	private User user;
	private Post post;
	
	public Comment() {
	}

	public Comment(String commentId, String comment, LocalDate dateCreated, LocalDate dateUpdated, User user,
			Post post) {
		this.commentId = commentId;
		this.comment = comment;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.user = user;
		this.post = post;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + ", user=" + user + ", post=" + post + "]";
	}
	
}
