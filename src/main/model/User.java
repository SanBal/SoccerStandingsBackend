package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	public User(String username, String password) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User: id = " + this.id + "; username = " + this.username;
	}
}
