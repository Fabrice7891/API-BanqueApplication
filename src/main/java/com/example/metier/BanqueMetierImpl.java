package com.example.metier;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DAO.ClientRepository;
import com.example.DAO.CompteRepository;
import com.example.DAO.OperationRepository;
import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.Operation;
import com.example.entities.Retrait;
import com.example.entities.Versement;

@Service
 @Transactional
public class BanqueMetierImpl implements IBanqueMetier{

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	  @Override 
	  public Compte consulterCompte(String codeCpte) { Compte
	  cp=compteRepository.findById1(codeCpte); if(cp==null) throw new RuntimeException("Compte Introuvable"); 
	  return cp; }
	 

	/*
	 * private Compte findById(String codeCpte) {
	 * 
	 * return compteRepository.findById1(codeCpte); }
	 */


	@Override
	public void verser(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp=consulterCompte(codeCpte);
		Versement v= new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant); // mise a jour du solde
		compteRepository.save(cp);
	}
	
	
	/*
	 * @Override public double verser1(String codeCpte, double montant) { // TODO
	 * Auto-generated method stub Compte cp=consulterCompte(codeCpte); Versement v=
	 * new Versement(new Date(), montant, cp); operationRepository.save(v); double
	 * mt =cp.setSolde(cp.getSolde()+montant); // mise a jour du solde
	 * compteRepository.save(cp); return mt; }
	 */
	 
	

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp=consulterCompte(codeCpte);
		double facilitedecaisse=0;
		if(cp instanceof CompteCourant)
			facilitedecaisse=((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+facilitedecaisse<montant)
			 throw new RuntimeException("Solde Insuffisant");
		Retrait r= new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant); // mise a jour du solde
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		//return null;
		return operationRepository.listOperation(codeCpte, new PageRequest(page,size));
	}


	@Override
	public Collection<Compte> listeCompte() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
		
	}


	
	@Override
	public Collection<Client> listeClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
		
	}


}
