package com.pramithas.service;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pramithas.entity.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class UserServiceTest extends AbstractTestNGSpringContextTests {

	private static Logger logger = Logger.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	private User firstUser;
	private User secondUser;

	/**
	 * This method creates Test Users
	 *
	 */
	private void createUsers() {

		firstUser = new User();
		firstUser.setId("588857a0b26a912bac6cc915");
		firstUser.setFirstName("Pramithas");
		firstUser.setLastName("Dhakal");
		firstUser.setAddress("Sindhuli");
		firstUser.setEmail("dhakalpramithas@gmail.com");
		firstUser.setPhone("98457345612");
		firstUser.setPosition("Software Engineer");

		secondUser = new User();
		secondUser.setId("588857e1b26a912bac6cc916");
		secondUser.setFirstName("Spartakas");
		secondUser.setLastName("Dhakal");
		secondUser.setAddress("Pokhara");
		secondUser.setEmail("dhakalspartakas@gmail.com");
		secondUser.setPhone("9845470361");
		secondUser.setPosition("Student");

	}

	/**
	 * Asserts that User Properties are not null.
	 *
	 * @param User
	 */
	private void assertNotNullUserProperties(User user) {
		Assert.assertNotNull("User must not be null!", user);
		Assert.assertNotNull("Id must not be null!", user.getId());
		Assert.assertNotNull("Firstname must not be null!", user.getFirstName());
		Assert.assertNotNull("Lastname must not be null!", user.getLastName());
		Assert.assertNotNull("Address must not be null!", user.getAddress());
		Assert.assertNotNull("Phone must not be null!", user.getPhone());
		Assert.assertNotNull("Position must not be null!", user.getPosition());

	}

	/**
	 * The annotated method will be run before any test method belonging to the
	 * classes inside the <test> tag is run.
	 *
	 */
	@BeforeTest
	public void beforeTest() {
		logger.debug("BeforeTest method is run...");
	}

	/**
	 * The annotated method will be run before the first test method in the
	 * current class is invoked.
	 *
	 */
	@BeforeClass
	public void beforeClass() {
		logger.debug("BeforeClass method is run...");
		createUsers();
	}

	/**
	 * The annotated method will be run before each test method.
	 *
	 */
	@BeforeMethod
	public void beforeMethod() {
		logger.debug("BeforeMethod method is run...");
	}

	/**
	 * Tests the process of adding user
	 *
	 */
	@Test
	public void addUser() {
		assertNotNullUserProperties(firstUser);
		assertNotNullUserProperties(secondUser);
		Assert.assertEquals(firstUser, userService.save(firstUser));
		Assert.assertEquals(secondUser, userService.save(secondUser));

	}

	/**
	 * Tests the process of querying user
	 *
	 */
	@Test
	public void getUserById() {

		// Test First User

		User testUser = userService.findById(firstUser.getId());
		assertNotNullUserProperties(testUser);
		Assert.assertEquals("588857a0b26a912bac6cc915", testUser.getId());
		Assert.assertEquals("pramithas", testUser.getFirstName());
		Assert.assertEquals("dhakal", testUser.getLastName());
		Assert.assertEquals("sindhuli", testUser.getAddress());
		Assert.assertEquals("dhakalpramithas@gmail.com", testUser.getEmail());
		Assert.assertEquals("9876524234", testUser.getPhone());
		Assert.assertEquals("Software Engineer", testUser.getPosition());

		// Test second User

		User testUser1 = userService.findById(secondUser.getId());
		assertNotNullUserProperties(testUser1);
		Assert.assertEquals("588857e1b26a912bac6cc916", testUser1.getId());
		Assert.assertEquals("Spartakas", testUser1.getFirstName());
		Assert.assertEquals("Dhakal", testUser1.getLastName());
		Assert.assertEquals("Pokhara", testUser1.getAddress());
		Assert.assertEquals("dhakalspartakas@gmail.com", testUser1.getEmail());
		Assert.assertEquals("9845470361", testUser1.getPhone());
		Assert.assertEquals("Software Engineer", testUser1.getPosition());

	}

	/**
	 * Tests the process of deleting user
	 *
	 */
	@Test
	public void deleteUser() {

		assertNotNullUserProperties(secondUser);
		Assert.assertEquals((Object) 1L, userService.removeById(firstUser.getId()));
		Assert.assertEquals((Object) 1L, userService.removeById(secondUser.getId()));

	}

	/**
	 * Test the numbers of users
	 *
	 */
	@Test
	public void getUserCount() {
		Assert.assertEquals(2, userService.findAll().size());
	}

	/**
	 * The annotated method will be run after all the test methods in the
	 * current class have been run.
	 *
	 */
	@AfterClass
	public void afterClass() {
		logger.debug("AfterClass method is run...");
	}

	/**
	 * The annotated method will be run after all the test methods belonging to
	 * the classes inside the <test> tag have run.
	 *
	 */
	@AfterTest
	public void afterTest() {
		logger.debug("AfterTest method is run...");
	}

	/**
	 * The annotated method will be run after each test method.
	 *
	 */
	@AfterMethod
	public void afterMethod() {
		logger.debug("AfterMethod method is run...");
	}

}
