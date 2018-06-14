package main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.database.repositories.UserRepository;
import main.model.User;

/**
 * Represents a REST web service for getting and handling the user(s) of the
 * SoccerStandings web application.
 * 
 * @author Sanjeev
 *
 */
@RestController
@RequestMapping("/users")
public class UsersService {

	@Autowired
	UserRepository userRepository;

	/**
	 * Get service for getting all users.
	 * 
	 * @return
	 */
	@GetMapping
	public @ResponseBody Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	/**
	 * Get service for getting a specific user.
	 * 
	 * @return
	 */
	@GetMapping(path = "/{username}")
	public @ResponseBody User getUser(@PathVariable String username) {
		return userRepository.findByUsername(username);
	}
}
