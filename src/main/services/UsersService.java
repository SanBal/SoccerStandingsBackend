package main.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.model.User;

@RestController
public class UsersService {

	@RequestMapping(path = "/users")
	public @ResponseBody Iterable<User> getUsers() {
		List<User> users = Arrays.asList(new User("test", "test"));
		return users;
	}
}
