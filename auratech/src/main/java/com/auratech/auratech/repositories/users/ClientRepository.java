package com.auratech.auratech.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.users.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

}
