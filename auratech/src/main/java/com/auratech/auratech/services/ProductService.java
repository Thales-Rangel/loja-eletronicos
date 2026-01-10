package com.auratech.auratech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auratech.auratech.dto.ProductDTO;
import com.auratech.auratech.models.Product;
import com.auratech.auratech.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public void save(ProductDTO dto) {
		Product product = new Product(dto);
		repository.save(product);
	}
	
	public List<ProductDTO> listAll() {
		List<Product> all = repository.findAll();
		
		return all.stream().map(ProductDTO::new).toList();
	}
	
	public void delete(Long id) {
		Optional<Product> byId = repository.findById(id);
		
		if (byId.isEmpty()) {
			return;
		}
		
		Product product = byId.get();
		repository.delete(product);
	}
	
	public ProductDTO findById(Long id) {
		Optional<Product> byId = repository.findById(id);
		
		if (byId.isEmpty()) {
			return null;
		}
		
		ProductDTO productDTO = new ProductDTO(byId.get());
		return productDTO;
	}

}
