package com.auratech.auratech.dto.shopping;

import java.util.List;

import com.auratech.auratech.dto.ProductDTO;
import com.auratech.auratech.dto.users.ClientDTO;
import com.auratech.auratech.models.shopping.ShoppingCart;

public class ShoppingCartDTO {

	private Long id;

	private ClientDTO client;
	private List<ProductDTO> products;

	public ShoppingCartDTO(ShoppingCart cart) {
		this.id = cart.getId();

		this.client = new ClientDTO(cart.getClient());
		this.products = cart.getProducts().stream().map(ProductDTO::new).toList();
	}

	public ShoppingCartDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
