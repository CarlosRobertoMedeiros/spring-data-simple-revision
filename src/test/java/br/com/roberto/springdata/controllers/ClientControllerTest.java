package br.com.roberto.springdata.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.roberto.springdata.entities.Client;
import br.com.roberto.springdata.entities.User;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ClientControllerTest {
	
	@Autowired
	WebClient webClient;
	
	@Autowired
	Client client;
	
	@Autowired
	User user;
	
	@Test
	void getAllClients() {
		
		webClient.get()
			.uri("http://localhost:8080/clients")
			.retrieve()
			.bodyToFlux(Client.class);
		
				
		//Assertions.assertEquals(nome,"10");
		
		
	}

}
