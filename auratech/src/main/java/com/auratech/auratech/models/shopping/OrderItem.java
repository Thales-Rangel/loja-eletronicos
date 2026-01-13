package com.auratech.auratech.models.shopping;

import com.auratech.auratech.dto.shopping.OrderItemDTO;
import com.auratech.auratech.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Product product;

	@ManyToOne
	@JsonIgnore // Para evitar repetição na serialização
	private PurchaseOrder order;

	private int quantity;
	private float priceAtPurchase; // Preço unitário no momento da compra
	
	public OrderItem(OrderItemDTO dto) {
		this.id = dto.getId();
		this.product = new Product(dto.getProduct());
		this.order = new PurchaseOrder(dto.getOrder());
		this.quantity = dto.getQuantity();
		this.priceAtPurchase = dto.getPriceAtPurchase();
	}

	public OrderItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPriceAtPurchase() {
		return priceAtPurchase;
	}

	public void setPriceAtPurchase(float priceAtPurchase) {
		this.priceAtPurchase = priceAtPurchase;
	}

}
