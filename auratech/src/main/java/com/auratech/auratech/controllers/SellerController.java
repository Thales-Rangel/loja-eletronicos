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

import com.auratech.auratech.dto.SellerDTO;
import com.auratech.auratech.services.SellerService;

@Controller
@RequestMapping("/users/sellers")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@PostMapping
	public void insertSeller(@RequestBody SellerDTO dto) {
		service.save(dto);
	}
	
	@GetMapping
	public List<SellerDTO> listAllSellers() {
		return service.listAll();
	}
	
	@PutMapping
	public void updateSeller(@RequestBody SellerDTO dto) {
		service.save(dto);
	}
	
	@DeleteMapping("/{CPF}")
	public ResponseEntity<Void> deleteSeller(@PathVariable String CPF) {
		service.delete(CPF);
		return ResponseEntity.ok().build();
	}

}
