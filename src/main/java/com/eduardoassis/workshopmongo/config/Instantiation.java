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
import com.eduardoassis.workshopmongo.dto.AuthorDTO;
import com.eduardoassis.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("19/05/2024"), "Partiu Viajem", "Vou viajar para Paris!!!!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("19/05/2024"), "Bom dia", "Acordei felizão hoje!!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("19/05/2024"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("19/05/2024"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("19/05/2024"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
	}

}
