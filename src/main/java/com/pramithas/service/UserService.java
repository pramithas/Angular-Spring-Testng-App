package com.pramithas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramithas.entity.User;
import com.pramithas.repository.UserRepository;

/**
 * <p>This is the service class which sits in the middle of Repository interface 
 * <code>UserRepository</code> and controller class <code> UserController</code>.
 * This class basically helps the business layer communicate with data layer. </p>
 * @author Pramithas
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @return This method returns the List of all the users in database
	 */

	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * 
	 * @param user This parameter is the user Object
	 * @return This method returns a User object
	 */

	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * 
	 * @param id This parameter contains the User id
	 * @return This method returns a Long value that acts as a flag
	 */
	public Long removeById(String id) {
		return userRepository.removeById(id);
	}

	/**
	 * 
	 * @param id This parameter contains the user id
	 * @return This method returns the User object
	 */
	public User findById(String id) {
		return userRepository.findById(id);
	}
}
