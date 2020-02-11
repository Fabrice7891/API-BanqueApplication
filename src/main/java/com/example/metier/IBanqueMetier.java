package com.example.metier;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.Operation;

public interface IBanqueMetier {

	public Compte consulterCompte (String codeCpte);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1,String codeCpte2, double montant);
	public Page<Operation> listOperation (String codeCpte,int page , int size);
	//double verser1(String codeCpte, double montant);
	public Collection<Compte> listeCompte();
	public Collection<Client> listeClient();
	
}
