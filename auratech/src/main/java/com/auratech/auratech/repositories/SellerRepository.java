package com.auratech.auratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {

}
