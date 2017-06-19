package guru.springframework.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
public class Post {
@Id
@GeneratedValue
	private Integer Id;
	private String postText;
	private String postType;
	private Date dateCreated;


	public Post() {
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
