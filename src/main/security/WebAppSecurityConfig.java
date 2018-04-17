package main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import main.services.UserDetailsServiceImpl;

/**
 * Represents a spring security configure-adapter which enables HTTP security.
 * @author Sanjeev
 *
 */
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(this.userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// each HTTP request must be authenticated with HTTP basic authentication
		// the user with the credentials of the basic authentication within the incoming request
		// must have the spring security role 'USER'
		http.authorizeRequests()
			.anyRequest()
			.hasRole("USER")
			.and().httpBasic();
	}
}
