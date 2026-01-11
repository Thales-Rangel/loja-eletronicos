package com.auratech.auratech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auratech.auratech.models.Client;
import com.auratech.auratech.models.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
	
	List<ShoppingList> findByClient(Client client);

}
