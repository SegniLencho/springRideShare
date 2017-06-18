package guru.springframework.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String postText;
	private String postType;
	private Date dateCreated;

	//private User user;// who posted it
//	private List<Like> like; // can have many likes
//	private List<Comment> comment; // can have many comments

	public Post() {
	}

	public Post(String postText, String postType) {
		this.postText = postText;
		this.postType = postType;
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



//	public User getUser() {
//		return user;
//	}

//	public void setUser(User user) {
//		this.user = user;
//	}

//	public List<Like> getLike() {
//		return like;
//	}

//	public void setLike(List<Like> like) {
//		this.like = like;
//	}

//	public List<Comment> getComment() {
//		return comment;
//	}

//	public void setComment(List<Comment> comment) {
//		this.comment = comment;
//	}

	@Override
	public String toString() {
		return "Post [postId=" + Id + ", postText=" + postText + ", postType=" + postType + ", dateCreated="
				+ dateCreated +", user="  + "]";
	}


}
