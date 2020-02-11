package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.DAO.ClientRepository;
import com.example.DAO.CompteRepository;
import com.example.DAO.OperationRepository;
import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.CompteEpargne;
import com.example.entities.Retrait;
import com.example.entities.Versement;
import com.example.metier.IBanqueMetier;

@SpringBootApplication
public class BanqueProjectApplication implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
    private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private IBanqueMetier banqueMetier;
	
	
	public static void main(String[] args) {
	SpringApplication.run(BanqueProjectApplication.class, args);
	
	
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Client c1=clientRepository.save(new Client("Fabrice", "fabrice@test.com"));
		Client c2=clientRepository.save(new Client("Marcel", "marcel@test.com"));
		Client c3=clientRepository.save(new Client("nokam", "nokam@test.com"));
		Client c4=clientRepository.save(new Client("John", "john@test.com"));
		Client c5=clientRepository.save(new Client("Romuald", "romuald@test.com"));
		
		Compte cp1=compteRepository.save(new CompteCourant("C1", new Date(), 50000, c1, 10000));
		Compte cp2=compteRepository.save(new CompteEpargne("C2", new Date(), 60700, c2, 2.5));
		Compte cp3=compteRepository.save(new CompteCourant("C3", new Date(), 50000, c3, 10000));
		Compte cp4=compteRepository.save(new CompteEpargne("C4", new Date(), 60700, c4, 2.5));
		Compte cp5=compteRepository.save(new CompteCourant("C5", new Date(), 50000, c5, 10000));
		//Compte cp2=compteRepository.save(new CompteEpargne("C2", new Date(), 60700, c2, 2.5));
		
		operationRepository.save(new Versement(new Date(), 15000, cp1));
		operationRepository.save(new Retrait(new Date(), 12000, cp2));
		
		
		 banqueMetier.verser("c1", 9999);
		Compte cp= banqueMetier.consulterCompte("c1");
		System.out.println("Code :"+cp.getCodeCompte()+"\n Solde :"+cp.getSolde()+"\n Propietaire :"+cp.getClient().getNom());
	}

}
