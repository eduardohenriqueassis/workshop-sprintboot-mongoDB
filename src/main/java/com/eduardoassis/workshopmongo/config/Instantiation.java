package com.eduardoassis.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.eduardoassis.workshopmongo.domain.Post;
import com.eduardoassis.workshopmongo.domain.User;
import com.eduardoassis.workshopmongo.repository.PostRepository;
import com.eduardoassis.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements ApplicationRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "Rua 2, 978", "10-08-1973", "50", "Brazil");
		User alex = new User(null, "Alex Green", "alex@gmail.com", "Rua 3, 978", "10-07-1979", "45", "Portugal");
		User bob = new User(null, "Bob Grey", "bob@gmail.com", "Rua 4, 978", "10-03-1993", "31", "Brazil");

		Post post1 = new Post(null, sdf.parse("19/05/2024"), "Partiu Viajem", "Vou viajar para Paris!!!!", maria);
		Post post2 = new Post(null, sdf.parse("19/05/2024"), "Bom dia", "Acordei felizão hoje!!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
