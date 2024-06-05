
package fr.diginamic;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;

	@Temporal(TemporalType.DATE)
	@Column(name = "local_date")
	private Date localDate;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "id_banque")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "client_compte", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
	private Set<Compte> comptes;

	// constructeur sans parametre : utilisé par Hibernate
	public Client() {

	}

	public Client( String nom, String prenom, Date localDate, Adresse adresse
			) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.localDate = localDate;
		this.adresse = adresse;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the localDate
	 */
	public Date getLocalDate() {
		return localDate;
	}

	/**
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
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
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param localDate the localDate to set
	 */
	public void setLocalDate(Date localDate) {
		this.localDate = localDate;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	};
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", localDate=" + localDate + ", adresse="
				+ adresse + ", comptes=" + comptes + "]";
	}







}