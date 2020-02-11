package com.example.web;




import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.Operation;
import com.example.metier.IBanqueMetier;

@RestController
@CrossOrigin("*")
public class BanqueControlleur {
	
	@Autowired
	private IBanqueMetier banqueMetier;
	
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/listeComptes")
	  public Collection<Compte> listercompte() {
		
		return banqueMetier.listeCompte(); }
	
	 @GetMapping("/ConsulteSold")
	  public Compte consulter(@RequestParam(name = "c", defaultValue = "")String codeCpte) 
	 {return banqueMetier.consulterCompte(codeCpte); }
	 
	 @PutMapping("/Verser")
	 public void verser(@RequestParam(name = "c", defaultValue = "")String codeCpte,
			 @RequestParam(name = "mt", defaultValue = "")double montant) {
			banqueMetier.verser(codeCpte, montant);
		}
	 
	
	@PutMapping("/retirer")
	public void retirer(@RequestParam(name = "c", defaultValue = "")String codeCpte,
			 @RequestParam(name = "mt", defaultValue = "0")double montant) {
		banqueMetier.retirer(codeCpte, montant);
	}
	
	@PutMapping("/virer")
	public void virement(@RequestParam(name = "c1", defaultValue = "")String codeCpte1,
			@RequestParam(name = "c2", defaultValue = "")String codeCpte2,
			 @RequestParam(name = "mt", defaultValue = "0")double montant) {
		banqueMetier.virement(codeCpte1, codeCpte2, montant);
		
	}
    
	
	@GetMapping("/ListeOperationParCompte")
	Page<Operation> listeOpreationParcompte(@RequestParam(name = "c", defaultValue = "")String codeCpte,
			@RequestParam(name = "page", defaultValue = "0")int page, 
			@RequestParam(name = "size", defaultValue = "4")int size){
	   return banqueMetier.listOperation(codeCpte, page, size)	;
	}
	
	
	@GetMapping("/listeClient")
	  public Collection<Client> listerclients() {
		
		return banqueMetier.listeClient(); }

}
