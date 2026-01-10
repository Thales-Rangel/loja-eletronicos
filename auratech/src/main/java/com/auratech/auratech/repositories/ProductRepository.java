package com.auratech.auratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
