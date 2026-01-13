package com.auratech.auratech.controllers.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auratech.auratech.dto.shopping.PurchaseOrderDTO;
import com.auratech.auratech.dto.users.ClientDTO;
import com.auratech.auratech.models.shopping.PurchaseOrder;
import com.auratech.auratech.services.shopping.PurchaseOrderService;
import com.auratech.auratech.services.users.ClientService;

@Controller
@RequestMapping("/purchase-order")
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderService service;
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/buy")
	public PurchaseOrderDTO placeAnOrder(@RequestBody PurchaseOrderDTO dto) {
		PurchaseOrder purchaseOrder = service.create(dto);
		return new PurchaseOrderDTO(purchaseOrder);
	}
	
	@GetMapping
	public List<PurchaseOrderDTO> listAllOrders() {
		return service.listAll();
	}
	
	@GetMapping("/my-orders/{cpf}")
	public List<PurchaseOrderDTO> listOrdersByClient(@PathVariable String cpf) {
		ClientDTO byId = clientService.findById(cpf);
		return service.findByClient(byId);
	}
	
	@GetMapping("/{id}")
	public PurchaseOrderDTO findAOrder(Long id) {
		return service.findById(id);
	}

}
