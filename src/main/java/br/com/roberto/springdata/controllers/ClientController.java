package br.com.roberto.springdata.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.springdata.entities.Client;
import br.com.roberto.springdata.services.ClientService;

@RestController
@RequestMapping(value = "/clients" , 
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

	private ClientService clientService;

	public ClientController() {
	}

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> resultado = clientService.findAll();
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Client> create(@RequestBody Client client) {
		 Client innerClient =  clientService.save(client);
		 return ResponseEntity.ok(innerClient);
	}
	
	

}
