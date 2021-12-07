package br.com.roberto.springdata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.springdata.entities.User;
import br.com.roberto.springdata.services.UserService;

@RestController
@RequestMapping(value = "/users") 
//	consumes = MediaType.APPLICATION_JSON_VALUE,
//	produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

//	public UserController(UserService userService) {
//		this.userService = new UserService() ;
//	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<User>> findAll() {
		List<User> resultado = userService.findAll();
		return ResponseEntity.ok(resultado);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<User>> findAll(Pageable pageable) {
		// Variações
		// http://localhost:8080/users/page?page=1&size=12&sort=name,desc
		Page<User> resultado = userService.findAll(pageable);
		return ResponseEntity.ok(resultado);
	}

	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<User>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary,
			@RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
		Page<User> result = userService.searchSalary(minSalary, maxSalary, pageable);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<User>> searchByName(@RequestParam(defaultValue = " ") String name, Pageable pageable) {
		Page<User> result = userService.searchName(name, pageable);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/search-name-2")
	public ResponseEntity<Page<User>> findByNameContainingIgnoreCase(@RequestParam(defaultValue = " ") String name,
			Pageable pageable) {
		Page<User> result = userService.findByNameContainingIgnoreCase(name, pageable);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/search-salary-2")
	public ResponseEntity<Page<User>> findBySalaryBetween(@RequestParam(defaultValue = "0") Double minSalary,
			@RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
		Page<User> result = userService.findBySalaryBetween(minSalary, maxSalary, pageable);
		return ResponseEntity.ok(result);
	}

}
