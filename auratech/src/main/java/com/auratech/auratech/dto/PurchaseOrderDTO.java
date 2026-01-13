package com.auratech.auratech.dto;

import java.util.List;

import com.auratech.auratech.models.PurchaseOrder;

public class PurchaseOrderDTO {

	private Long id;
	private float totalPrice;

	private ClientDTO client;
	private List<OrderItemDTO> items;

	public PurchaseOrderDTO(PurchaseOrder order) {
		this.id = order.getId();
		this.totalPrice = order.getTotalPrice();

		this.client = new ClientDTO(order.getClient());
		this.items = order.getItems().stream().map(OrderItemDTO::new).toList();
	}

	public void calculateTotal() {
		this.totalPrice = (float) items.stream()
				.mapToDouble(item -> item.getPriceAtPurchase() * item.getQuantity())
				.sum();
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

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}

}
