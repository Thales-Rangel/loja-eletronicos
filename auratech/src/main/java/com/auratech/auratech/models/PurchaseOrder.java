package com.auratech.auratech.models;

import java.util.List;

import com.auratech.auratech.dto.PurchaseOrderDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float totalPrice;

	@ManyToOne
	private Client client;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> items;

	public PurchaseOrder(PurchaseOrderDTO dto) {
		this.id = dto.getId();
		this.totalPrice = dto.getTotalPrice();

		this.client = new Client(dto.getClient());
		this.items = dto.getItems().stream().map(OrderItem::new).toList();
	}

	public void calculateTotal() {
		this.totalPrice = (float) items.stream()
				.mapToDouble(item -> item.getPriceAtPurchase() * item.getQuantity())
				.sum();
	}

	public PurchaseOrder() {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

}
