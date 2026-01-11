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
import org.springframework.web.bind.annotation.RequestMapping;

import com.auratech.auratech.dto.ClientDTO;
import com.auratech.auratech.dto.ShoppingListDTO;
import com.auratech.auratech.services.ClientService;
import com.auratech.auratech.services.ShoppingListService;

@Controller
@RequestMapping("/shoppings-lists")
public class ShoppingListController {

	@Autowired
	private ShoppingListService service;
	@Autowired
	private ClientService clientService;

	@PostMapping
	public void saveShoppingList(ShoppingListDTO dto) {
		service.save(dto);
	}

	@GetMapping
	public List<ShoppingListDTO> listAllShoppingList() {
		return service.listAll();
	}

	@PutMapping
	public void updateShoppingList(ShoppingListDTO dto) {
		service.save(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteShoppingList(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ShoppingListDTO findAShoppingList(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping("/client/{cpf}")
	public List<ShoppingListDTO> findShoppingsListsByClient(@PathVariable String cpf) {
		ClientDTO client = clientService.findById(cpf);
		return service.findByClient(client);
	}

}
