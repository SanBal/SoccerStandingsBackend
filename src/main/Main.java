package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		// User user = new User("test", "test");
		//
		// DatabaseService.insertEntity(user);
		// DatabaseService.getSessionFactory().close();

		SpringApplication.run(Main.class);
	}
}
