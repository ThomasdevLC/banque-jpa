package fr.diginamic;

import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OperationsComptes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		int idCompte = 1;
		Compte compteVirement = em.find(Compte.class, idCompte);

		Virement virement1 = new Virement();
		virement1.setCompte(compteVirement);
		virement1.setLocalDateTime(new Date());
		virement1.setMontant(150.00);
		virement1.setMotif("garage");
		virement1.setBeneficiaire("Bob Garage");
		
		int idCompte2 = 2;
		Compte comptetrait = em.find(Compte.class, idCompte2);

		Operation operation1 = new Operation();
		operation1.setCompte(comptetrait);
		operation1.setLocalDateTime(new Date());
		operation1.setMontant(200.00);
		operation1.setMotif("retrait");

		em.persist(virement1);
		em.persist(operation1);

		em.getTransaction().commit();
		
//		List<T> operations;
//		operations.add(operation1);
//		operations.add(virement1);
//		
//		for (Operation operation : operations) {
//	        System.out.println(operation); 
//	    }
		
		em.close();
		emf.close();

	}
}
