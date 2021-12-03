package br.com.roberto.springdata.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.roberto.springdata.entities.Client;
import br.com.roberto.springdata.repositories.ClientRepository;

@Service
public class ClientService {

	private ClientRepository clientRepository;

	ClientService() {
	}

	public ClientService(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client save(Client client) {
		Client clientSaved = clientRepository.save(client);
		return clientSaved;
	}

}
