package com.auratech.auratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auratech.auratech.models.Users;

@Repository
public interface UsersReposiroty extends JpaRepository<Users, String> {

}
