package com.eduardoassis.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardoassis.workshopmongo.domain.User;
import com.eduardoassis.workshopmongo.dto.UserDTO;
import com.eduardoassis.workshopmongo.repository.UserRepository;
import com.eduardoassis.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), objDTO.getAddress(), objDTO.getDateOfBirth(), objDTO.getAge(), objDTO.getCountryOfBirth());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj){
		
		Optional<User> newOptional = repo.findById(obj.getId());
		
			User updatedUser = newOptional.get();
			updateData(updatedUser, obj);
			return repo.save(updatedUser);
		
	}

	private void updateData(User updatedUser, User obj) {
		updatedUser.setName(obj.getName());
		updatedUser.setEmail(obj.getEmail());
		updatedUser.setAddress(obj.getAddress());
		updatedUser.setDateOfBirth(obj.getDateOfBirth());
		updatedUser.setAge(obj.getAge());
		updatedUser.setCountryOfBirth(obj.getCountryOfBirth());
		
	}
}
