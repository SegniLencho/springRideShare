package guru.springframework.domain;

import java.time.LocalDate;

public class Like {
	private int likeId;
	private Post post;
	private User user;
	private LocalDate dateCreated;
	private LocalDate dateUpdated;

	public Like() {
	}

	public Like(int likeId, Post post, User user, LocalDate dateCreated, LocalDate dateUpdated) {
		this.likeId = likeId;
		this.post = post;
		this.user = user;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "Like [likeId=" + likeId + ", post=" + post + ", user=" + user + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + "]";
	}

}
