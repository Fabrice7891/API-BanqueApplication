package com.example.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entities.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
