package main;

import main.database.DatabaseService;
import main.model.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("test");

		DatabaseService.insertEntity(user);
		DatabaseService.getSessionFactory().close();
	}
}
