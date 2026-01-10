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

import com.auratech.auratech.dto.ProductDTO;
import com.auratech.auratech.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public void createProduct(@RequestBody ProductDTO dto) {
		service.save(dto);
	}
	
	@GetMapping
	public List<ProductDTO> listAllProducts() {
		return service.listAll();
	}
	
	@PutMapping
	public void updateProduct(@RequestBody ProductDTO dto) {
		service.save(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ProductDTO findAProduct(@PathVariable Long id) {
		return service.findById(id);
	}

}
