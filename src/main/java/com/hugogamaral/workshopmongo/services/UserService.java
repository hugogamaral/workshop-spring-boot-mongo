package com.hugogamaral.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugogamaral.workshopmongo.domain.User;
import com.hugogamaral.workshopmongo.repository.UserRepository;
import com.hugogamaral.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
