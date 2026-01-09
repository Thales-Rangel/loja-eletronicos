package com.auratech.auratech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auratech.auratech.dto.ClientDTO;
import com.auratech.auratech.models.Client;
import com.auratech.auratech.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public void save(ClientDTO dto) {
		Client client = new Client(dto);
		repository.save(client);
	}

	public List<ClientDTO> listAll() {
		List<Client> all = repository.findAll();

		return all.stream().map(ClientDTO::new).toList();
	}
	
	public void delete(String CPF) {
		Optional<Client> byId = repository.findById(CPF);
		
		if (byId.isEmpty()) {
			return;
		}
		
		Client client = byId.get();
		repository.delete(client);
	}
	
	public ClientDTO findById(String CPF) {
		Optional<Client> byId = repository.findById(CPF);
		
		if (byId.isEmpty()) {
			return null;
		}
		
		ClientDTO clientDTO = new ClientDTO(byId.get());
		return clientDTO;
	}

}
