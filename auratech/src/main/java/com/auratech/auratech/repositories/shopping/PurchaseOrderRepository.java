package com.auratech.auratech.repositories.shopping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.shopping.PurchaseOrder;
import com.auratech.auratech.models.users.Client;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
	
	List<PurchaseOrder> findByClient(Client client);

}
