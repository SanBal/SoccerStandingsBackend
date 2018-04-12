package main.database.repositories;

import org.springframework.data.repository.CrudRepository;

import main.model.User;

/**
 * Repository interface which provides CRUD operations for handling {@link User}
 * objects.
 * 
 * @author Sanjeev
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);

}
