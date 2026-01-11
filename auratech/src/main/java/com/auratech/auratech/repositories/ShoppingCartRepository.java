package com.auratech.auratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auratech.auratech.models.Client;
import com.auratech.auratech.models.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	
	ShoppingCart findByClient(Client client);

}
