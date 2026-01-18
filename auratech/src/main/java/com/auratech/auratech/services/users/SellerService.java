package com.auratech.auratech.services.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auratech.auratech.dto.users.SellerDTO;
import com.auratech.auratech.models.users.Seller;
import com.auratech.auratech.repositories.users.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public void save(SellerDTO dto) {
		Seller seller = new Seller(dto);
		repository.save(seller);
	}
	
	public List<SellerDTO> listAll() {
		List<Seller> all = repository.findAll();
		return all.stream().map(SellerDTO::new).toList();
	}
	
	public void delete(String CPF) {
		Optional<Seller> byId = repository.findById(CPF);
		
		if (byId.isEmpty()) {
			return;
		}
		
		Seller seller = byId.get();
		repository.delete(seller);
	}
	
	public SellerDTO findByID(String CPF) {
		Optional<Seller> byId = repository.findById(CPF);
		
		if (byId.isEmpty()) {
			return null;
		}
		
		SellerDTO sellerDTO = new SellerDTO(byId.get());
		return sellerDTO;
	}

}
