package com.pramithas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramithas.entity.User;
import com.pramithas.repository.UserRepository;

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
	 * @param user
	 *            This parameter is the user Object
	 * @return This method returns a User object
	 */

	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * 
	 * @param id
	 *            This parameter contains the User id
	 * @return This method returns a Long value that acts as a flag
	 */
	public Long removeById(String id) {
		return userRepository.removeById(id);
	}

	/**
	 * 
	 * @param id
	 *            This parameter contains the user id
	 * @return This method returns the User object
	 */
	public User findById(String id) {
		return userRepository.findById(id);
	}
}
