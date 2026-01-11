package com.auratech.auratech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auratech.auratech.dto.ClientDTO;
import com.auratech.auratech.dto.ShoppingListDTO;
import com.auratech.auratech.models.Client;
import com.auratech.auratech.models.ShoppingList;
import com.auratech.auratech.repositories.ShoppingListRepository;

@Service
public class ShoppingListService {
	
	@Autowired
	private ShoppingListRepository repository;
	
	public void save(ShoppingListDTO dto) {
		ShoppingList shoppingList = new ShoppingList(dto);
		repository.save(shoppingList);
	}
	
	public List<ShoppingListDTO> listAll() {
		List<ShoppingList> all = repository.findAll();
		
		return all.stream().map(ShoppingListDTO::new).toList();
	}
	
	public void delete(Long id) {
		Optional<ShoppingList> byId = repository.findById(id);
		
		if (byId.isEmpty()) {
			return;
		}
		
		ShoppingList shoppingList = byId.get();
		repository.delete(shoppingList);
	}
	
	public ShoppingListDTO findById(Long id) {
		Optional<ShoppingList> byId = repository.findById(id);
		
		if (byId.isEmpty()) {
			return null;
		}
		
		ShoppingListDTO shoppingListDTO = new ShoppingListDTO(byId.get());
		return shoppingListDTO;
	}
	
	public List<ShoppingListDTO> findByClient(ClientDTO dto) {
		Client client = new Client(dto);
		List<ShoppingList> byClient = repository.findByClient(client);
		
		return byClient.stream().map(ShoppingListDTO::new).toList();
	}

}
