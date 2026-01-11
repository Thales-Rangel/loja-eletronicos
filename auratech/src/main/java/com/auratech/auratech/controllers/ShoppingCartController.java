package com.auratech.auratech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auratech.auratech.dto.ClientDTO;
import com.auratech.auratech.dto.ShoppingCartDTO;
import com.auratech.auratech.services.ClientService;
import com.auratech.auratech.services.ShoppingCartService;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService service;
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public void createShoppingCart(@RequestBody ShoppingCartDTO dto) {
		service.save(dto);
	}
	
	@GetMapping
	public List<ShoppingCartDTO> listAllShoppingCart() {
		return service.listAll();
	}
	
	@PutMapping
	public void updateShoppingCart(ShoppingCartDTO dto) {
		service.save(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteShoppingCart(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ShoppingCartDTO findAShoppingCart(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("/client/{cpf}")
	public ShoppingCartDTO findShoppingCartByClient(@PathVariable String cpf) {
		ClientDTO client = clientService.findById(cpf);
		return service.findByClient(client);
	}

}
