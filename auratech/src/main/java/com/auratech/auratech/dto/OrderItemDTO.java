package com.auratech.auratech.dto;

import com.auratech.auratech.models.OrderItem;

public class OrderItemDTO {

	private Long id;

	private ProductDTO product;

	private PurchaseOrderDTO order;

	private int quantity;
	private float priceAtPurchase;
	
	public OrderItemDTO(OrderItem item) {
		this.id = item.getId();
		this.product = new ProductDTO(item.getProduct());
		this.order = new PurchaseOrderDTO(item.getOrder());
		this.quantity = item.getQuantity();
		this.priceAtPurchase = item.getPriceAtPurchase();
	}

	public OrderItemDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public PurchaseOrderDTO getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrderDTO order) {
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
