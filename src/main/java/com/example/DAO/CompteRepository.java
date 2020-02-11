package com.example.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entities.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String>{

	 
	
	  @Query("select c from Compte c where c.codeCompte=:x") 
	  public Compte findById1(@Param("x")String codeCpte);
	 
	
}
