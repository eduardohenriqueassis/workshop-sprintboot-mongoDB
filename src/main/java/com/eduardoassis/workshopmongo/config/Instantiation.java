package com.eduardoassis.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.eduardoassis.workshopmongo.domain.User;
import com.eduardoassis.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements ApplicationRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "Rua 2, 978", "10-08-1973", "50", "Brazil");
		User alex = new User(null, "Alex Green", "alex@gmail.com", "Rua 3, 978", "10-07-1979", "45", "Portugal");
		User bob = new User(null, "Bob Grey", "bob@gmail.com", "Rua 4, 978", "10-03-1993", "31", "Brazil");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
