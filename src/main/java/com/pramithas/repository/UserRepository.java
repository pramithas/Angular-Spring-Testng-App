package com.pramithas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pramithas.entity.User;

/**
*This is the repository interface that connects service layer with datalayer
@author Pramithas
**/
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * Get the list of all users from the database
	 * @return List of users currently persisted in the database.
	 */
	public List<User> findAll();
	
	/**
	 * This method saves the user in the database
	 * @param user The user to be saved
	 * @return User The user that was saved
	 */
	public User save(User user);

	/**
	 * This method returns User when given it's id
	 * @param id This is the id of the user to be found
	 * @return User The User that has the id specified
	 */
	public User findById(String id);

	/**
	 * This method deletes a specified user when it's id is given
	 * @param id This parameter is the id of the user to be deleted
	 * @return A long value that is 0 or 1 which signifies whether the user was successfully 
	 *         deleted
	 */
	public Long removeById(String id);
}
