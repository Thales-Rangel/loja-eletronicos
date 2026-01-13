package com.auratech.auratech.repositories.shopping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.shopping.ShoppingCart;
import com.auratech.auratech.models.users.Client;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	
	ShoppingCart findByClient(Client client);

}
