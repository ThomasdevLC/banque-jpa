package fr.diginamic;

import java.util.List;
import java.util.Set;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numero;
	private double solde;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	@ManyToMany 
	@JoinTable(name = "client_compte", 
	joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
	private Set<Client> clients;

	// constructeur sans parametre : utilisé par Hibernate
	public Compte() {
	}
	

	public Compte( String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}

	/**
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", operations=" + operations
				+ ", clients=" + clients + "]";
	}



}