package com.auratech.auratech.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.Client;
import com.auratech.auratech.models.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
	
	List<PurchaseOrder> findByClient(Client client);

}
