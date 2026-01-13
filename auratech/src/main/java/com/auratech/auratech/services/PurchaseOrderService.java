package com.auratech.auratech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auratech.auratech.dto.ClientDTO;
import com.auratech.auratech.dto.PurchaseOrderDTO;
import com.auratech.auratech.models.Client;
import com.auratech.auratech.models.OrderItem;
import com.auratech.auratech.models.Product;
import com.auratech.auratech.models.PurchaseOrder;
import com.auratech.auratech.repositories.ClientRepository;
import com.auratech.auratech.repositories.ProductRepository;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository repository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ProductRepository productRepository;

	public PurchaseOrder create(PurchaseOrderDTO dto) {
		// Criando instância de pedido
		PurchaseOrder order = new PurchaseOrder();

		// Buscando o cliente no banco de dados para garantir sua existência
		Client client = clientRepository.findById(dto.getClient().getCPF())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
		order.setClient(client);

		// Convertendo os DTOs em modelos de itens
		List<OrderItem> items = dto.getItems().stream().map(itemDTO -> {

			// Buscado produtos diretamente do banco de dados para garantir as informações
			// atualizadas dos produtos
			Product product = productRepository.findById(itemDTO.getProduct().getId())
					.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

			// Verificando estoque
			if (product.getQuantity() < itemDTO.getQuantity()) {
				throw new RuntimeException("Estoque insuficiente para a compra do produto " + product.getName());
			}

			// Baixa no estoque
			product.setQuantity(product.getQuantity() - itemDTO.getQuantity());
			productRepository.save(product);

			// Finalizando item do pedido
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(itemDTO.getQuantity());
			orderItem.setPriceAtPurchase(product.getPrice());
			orderItem.setOrder(order);

			return orderItem;
		}).toList();

		// Finalizando pedido
		order.setItems(items);
		order.calculateTotal();

		return repository.save(order);
	}

	public void save(PurchaseOrderDTO dto) {
		PurchaseOrder purchaseOrder = new PurchaseOrder(dto);
		repository.save(purchaseOrder);
	}

	public List<PurchaseOrderDTO> listAll() {
		List<PurchaseOrder> all = repository.findAll();

		return all.stream().map(PurchaseOrderDTO::new).toList();
	}

	public void delete(Long id) {
		Optional<PurchaseOrder> byId = repository.findById(id);

		if (byId.isEmpty()) {
			return;
		}

		PurchaseOrder purchaseOrder = byId.get();
		repository.delete(purchaseOrder);
	}

	public PurchaseOrderDTO findById(Long id) {
		Optional<PurchaseOrder> byId = repository.findById(id);

		if (byId.isEmpty()) {
			return null;
		}

		PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO(byId.get());
		return purchaseOrder;
	}
	
	public List<PurchaseOrderDTO> findByClient(ClientDTO clientDTO) {
		Client client = new Client(clientDTO);
		List<PurchaseOrder> byClient = repository.findByClient(client);
		
		return byClient.stream().map(PurchaseOrderDTO::new).toList();
	}

}
