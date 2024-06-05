package fr.diginamic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CreateMultiComptes {
	public static void main(String[] args) {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	Adresse adresse = new Adresse();
	adresse.setNumero(12);
	adresse.setRue("Rue du puit");
	adresse.setCodePostal(34000);
	adresse.setVille("Montpellier");

	Banque banque = new Banque();
	banque.setNom("Ouest Banque");

	em.persist(banque);
	
	LivretA compteA = new LivretA();
	compteA.setNumero("059846");
	compteA.setSolde(1455.45);
	compteA.setTaux(1.15);
	
	SimpleDateFormat dateFormatCompte = new SimpleDateFormat("dd/MM/yyyy");
    Date dateCompte = null;
    try {
    	dateCompte = dateFormatCompte.parse("25/12/2020");
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	AssuranceVie compteB = new AssuranceVie();
	compteB.setNumero("059846");
	compteB.setSolde(5387.02);
	compteB.setLocalDate(dateCompte);
	compteB.setTaux(1.01);

	 SimpleDateFormat dateFormatNaissance = new SimpleDateFormat("dd/MM/yyyy");
     Date dateNaissance = null;
     try {
		dateNaissance = dateFormatNaissance.parse("25/02/1990");
	} catch (ParseException e) {
		e.printStackTrace();
	}

	Client client3 = new Client();
	client3.setNom("Example");
	client3.setPrenom("John");
	client3.setAdresse(adresse);
    client3.setLocalDate(dateNaissance); 
	client3.setBanque(banque);

	
	Set<Compte> comptesClient = new HashSet<Compte>();
	comptesClient.add(compteA);
	comptesClient.add(compteB);


	client3.setComptes(comptesClient);

	em.persist(compteA);
	em.persist(compteB);
	em.persist(client3);

	em.getTransaction().commit();
	
	for (Compte compte : comptesClient) {
        System.out.println(compte); 
    }

	em.close();
	emf.close();
	
	}
}