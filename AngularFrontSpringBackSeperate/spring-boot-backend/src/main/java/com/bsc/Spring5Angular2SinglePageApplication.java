package com.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5Angular2SinglePageApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Spring5Angular2SinglePageApplication.class, args);
	}
	
	//bootstap database at start of application
	public void run(String... strings) throws Exception {
		userRepository.save(new User("Ada","Lovelace"));
		userRepository.save(new User("Grace","Hopper"));
	}
}
