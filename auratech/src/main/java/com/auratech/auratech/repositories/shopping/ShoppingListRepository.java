package com.auratech.auratech.repositories.shopping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.shopping.ShoppingList;
import com.auratech.auratech.models.users.Client;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
	
	List<ShoppingList> findByClient(Client client);

}
