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
import com.auratech.auratech.services.ClientService;

@Controller
@RequestMapping("/users/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@PostMapping
	public void	createClient(@RequestBody ClientDTO dto) {
		service.save(dto);
	}
	
	@GetMapping
	public List<ClientDTO> lisAllClients() {
		return service.listAll();
	}
	
	@PutMapping
	public void updateClient(@RequestBody ClientDTO dto) {
		service.save(dto);
	}
	
	@DeleteMapping("/{CPF}")
	public ResponseEntity<Void> deleteClient(@PathVariable String CPF) {
		service.delete(CPF);
		return ResponseEntity.ok().build();
	}

}
