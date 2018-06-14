package main.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.security.WebAppSecurityConfig;

/**
 * Represents a REST web service which will be called initially when an user of
 * the SoccerStandings web application logs in.
 * 
 * @author Sanjeev
 *
 */
@RestController
@RequestMapping("/login")
public class LoginService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Get service which is called when an user of the SoccerStandings web
	 * application logs in. Returns a HTTP status 200 if the HTTP basic
	 * authentication is successful which is validated by
	 * {@link WebAppSecurityConfig} else {@link WebAppSecurityConfig} returns HTTP
	 * status 401.
	 * 
	 * @return {@link ResponseEntity}
	 */
	@GetMapping
	@ResponseBody
	public ResponseEntity<String> loginUser() {
		logger.info("LoginService: GET - loginUser");
		return new ResponseEntity<String>(HttpStatus.OK);

	}
}
