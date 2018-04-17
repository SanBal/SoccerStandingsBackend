package main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.database.repositories.UserRepository;
import main.model.User;

/**
 * Represents a spring security service to receive a spring security
 * {@link org.springframework.security.core.userdetails.User}.
 * 
 * @author Sanjeev
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// load the user with given username from the database
		User user = userRepository.findByUsername(username);

		if (user == null) {
			return null;
		}

		// transform the model user to a spring security user
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password("{noop}" + user.getPassword()) // usage of NoPasswordEncoder
				.roles("USER").build();
	}
}
