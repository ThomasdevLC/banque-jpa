package fr.diginamic;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CreateClient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Adresse adresse = new Adresse();
		adresse.setNumero(12);
		adresse.setRue("Rue de la Paix");
		adresse.setCodePostal(34000);
		adresse.setVille("Montpellier");

		Banque banque = new Banque();
		banque.setNom("Sud Banque");

		em.persist(banque);
		
		Compte compteLie = new Compte();
		compteLie.setNumero("059846");
		compteLie.setSolde(12854.25);
		


		Client client1 = new Client();
		client1.setNom("Test");
		client1.setPrenom("Jean");
		client1.setAdresse(adresse);
		client1.setLocalDate(new Date());
		client1.setBanque(banque);

		Client client2 = new Client();
		client2.setNom("Test");
		client2.setPrenom("Marie");
		client2.setAdresse(adresse);
		client2.setLocalDate(new Date());
		client2.setBanque(banque);
		
		
		Set<Compte> comptesClients = new HashSet<Compte>();
		comptesClients.add(compteLie);

		client1.setComptes(comptesClients);
		client2.setComptes(comptesClients);

		em.persist(compteLie);
		em.persist(client1);
		em.persist(client2);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
