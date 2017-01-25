package com.pramithas.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pramithas.entity.User;
import com.pramithas.service.UserService;

/**
 * <p>This is the controller class. This class acts as bridge between front end and backend</p>
 * @author Pramithas
 *
 */
@RestController
public class UserController {

	Logger log = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * This method find a User when the ID of the user is given
	 * @param id This parameter is the user id
	 * @return ResponseEntity<User>
	 */

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable("id") String id) {
		User user = userService.findById(id);

		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * This method returns all the posts
	 * @return List<User>
	 */

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllPosts() {
		List<User> users = userService.findAll();

		for (User user : users) {
			log.info("Reading user with name" + user.getFirstName() + "  " + user.getLastName());
		}

		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	/**
	 * This method saves a User object in database.
	 * 
	 * @param user This parameter contains the User object.        
	 * @param ucBuilder This parameter is used to build the Uri that is the location
	 *            of newly created User.      
	 * @return
	 */

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Void> savePost(@RequestBody User user, UriComponentsBuilder ucBuilder) {

		log.info("Saving user" + user.getFirstName() + " " + user.getLastName());

		userService.save(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @param id This parameter is the user id   
	 * @return This method returns response entity
	 */

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteById(@PathVariable("id") String id) {
		Long result = userService.removeById(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id This parameter contains the user id
	 * @param user This parameter contains the user object
	 * @return This method returns the Response Entity
	 */

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateById(@PathVariable("id") String id, @RequestBody @Valid User user) {

		log.info("updating user with" + user);
		userService.save(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
