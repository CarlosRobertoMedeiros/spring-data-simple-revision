package br.com.roberto.springdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.roberto.springdata.entities.User;
import br.com.roberto.springdata.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserService() {
	}

//	public UserService(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable) {
		return userRepository.searchSalary(minSalary, maxSalary, pageable);
	}
	
	public Page<User> searchName(String name, Pageable pageable) {
		return userRepository.searchName(name, pageable);
	}
	
	public Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable) {
		return userRepository.findByNameContainingIgnoreCase(name, pageable);
	}
	
	public Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable) {
		return userRepository.findBySalaryBetween(minSalary, maxSalary, pageable);
	}
	
	public User save(User user) {
		User userSaved = userRepository.save(user);
		return userSaved;
	}

	

	

	

}
