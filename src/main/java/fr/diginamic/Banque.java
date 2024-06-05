package fr.diginamic;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;

	@OneToMany(mappedBy = "banque")
	private List<Client> clients;

	public Banque() {

	}
	
	public Banque(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
        this.nom = nom;
		
	};
	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", clients=" + clients + "]";
	}


}
