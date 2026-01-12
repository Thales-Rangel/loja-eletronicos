package com.auratech.auratech.dto;

import java.util.List;

import com.auratech.auratech.models.PurchaseOrder;

public class PurchaseOrderDTO {

	private Long id;
	private float totalPrice;

	private ClientDTO client;
	private List<ProductDTO> products;

	public PurchaseOrderDTO(PurchaseOrder order) {
		this.id = order.getId();
		this.totalPrice = order.getTotalPrice();

		this.client = new ClientDTO(order.getClient());
		this.products = order.getProducts().stream().map(ProductDTO::new).toList();
	}

	public PurchaseOrderDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

}
