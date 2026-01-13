package com.auratech.auratech.services.shopping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auratech.auratech.dto.shopping.ShoppingCartDTO;
import com.auratech.auratech.dto.users.ClientDTO;
import com.auratech.auratech.models.shopping.ShoppingCart;
import com.auratech.auratech.models.users.Client;
import com.auratech.auratech.repositories.shopping.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository repository;

	public void save(ShoppingCartDTO dto) {
		ShoppingCart shoppingCart = new ShoppingCart(dto);
		repository.save(shoppingCart);
	}

	public List<ShoppingCartDTO> listAll() {
		List<ShoppingCart> all = repository.findAll();

		return all.stream().map(ShoppingCartDTO::new).toList();
	}

	public void delete(Long id) {
		Optional<ShoppingCart> byId = repository.findById(id);

		if (byId.isEmpty()) {
			return;
		}

		ShoppingCart shoppingCart = byId.get();
		repository.delete(shoppingCart);
	}

	public ShoppingCartDTO findById(Long id) {
		Optional<ShoppingCart> byId = repository.findById(id);

		if (byId.isEmpty()) {
			return null;
		}

		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO(byId.get());
		return shoppingCartDTO;
	}

	public ShoppingCartDTO findByClient(ClientDTO dto) {
		Client client = new Client(dto);

		ShoppingCart byClient = repository.findByClient(client);
		return new ShoppingCartDTO(byClient);
	}

}
