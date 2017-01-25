package com.pramithas;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Pramithas Dhakal
 * 
 * This is the main Spring Boot Application
 *
 */
@SpringBootApplication
public class Application {

	static Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		log.debug("app started");
		SpringApplication.run(Application.class, args);
	}

}