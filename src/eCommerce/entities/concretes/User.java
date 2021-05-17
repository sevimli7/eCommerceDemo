package eCommerce.entities.concretes;

import eCommerce.entities.abstracts.Entity;

public class User implements Entity{

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isVerify;
	
	public User() {
		super();
	}
	
	public User(int userId, String firstName, String lastName, String email, String password, boolean isVerify) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isVerify = isVerify;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(boolean isVerify) {
		this.isVerify = isVerify;
	}
	
	public String getFullName() {
		return this.getFirstName()+" "+this.getLastName();
	}

}
