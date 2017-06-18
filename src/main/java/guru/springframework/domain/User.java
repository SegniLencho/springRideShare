package guru.springframework.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User {

	private String firstName;
	private String lastName;
	private String gender;
	private int birthDate;
	private String email;
	private Date dateUpdated;
	private Date dateCreated;
	private String city;
	private String state;
	private String street;
	private String password;
	private String username;
	private int zipcode;
	private List<Post> post;
	private List<Comment> comment;
	private List<Like> like;
	private int userId;

	
	
	public int getUserId() {
		return userId;
	}

	public User() {

	}

	public User(String firstName, String lastName, String gender, int birthDate, String email, String city,
			String state, String street, int zipcode, String password, String username) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.email = email;
		this.city = city;
		this.state = state;
		this.street = street;
		this.zipcode = zipcode;
		this.password = password;
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public List<Post> getPost() {
		return post;
	}

	public void addPost(Post post) {
		this.post = new ArrayList<Post>();
		this.post.add(post);
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void addComment(Comment comment) {
		this.comment = new ArrayList<Comment>();
		this.comment.add(comment);
	}

	public List<Like> getLike() {
		return like;
	}

	public void addLike(Like like) {
		this.like = new ArrayList<Like>();
		this.like.add(like);
	}

//	public int login(String username, String password) {
//		DataAcess dataaccess = new DataAcess();
//		return dataaccess.login(username, password);
//	}

	public void setUserId(int userId) {
		this.userId = userId;
		
	}
	
//	public void register(String firstName, String lastName, String gender, int birthDate, String email, String city,
//			String state, String street, int zipcode, String password, String username) {
//		DataAcess.registerUser(firstName, lastName, gender, birthDate, email, city, state, street, zipcode, password,
//				username);
//	}
	
//	public void updateProfile( int userid,String firstName, String lastName, String gender, int birthDate, String email, String city,
//			String state, String street, int zipcode, String password, String username){
//		DataAcess.updateProfile(userid,firstName, lastName, gender,
//				birthDate, email, city, state, street, zipcode, password, username);
//	}
//
//	public User getUserData(int userid){
//
//    		return DataAcess.getUserData(userid);
//
//	}

//	public User getUserData(String username) {
//		return DataAcess.getUserData(username);
//	}
}