package com.auratech.auratech.dto.shopping;

import java.util.List;

import com.auratech.auratech.dto.ProductDTO;
import com.auratech.auratech.dto.users.ClientDTO;
import com.auratech.auratech.models.shopping.ShoppingList;

public class ShoppingListDTO {

	private Long id;
	private String name;

	private ClientDTO client;
	private List<ProductDTO> products;

	public ShoppingListDTO(ShoppingList list) {
		this.id = list.getId();
		this.name = list.getName();

		this.client = new ClientDTO(list.getClient());
		this.products = list.getProducts().stream().map(ProductDTO::new).toList();
	}

	public ShoppingListDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
