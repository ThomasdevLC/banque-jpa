package fr.diginamic;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "local_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date localDateTime;

	private double montant;
	private String motif;

	@ManyToOne
	@JoinColumn(name = "id_compte")
	private Compte compte;

	public Operation() {

	}

	public Operation(Date localDateTime, double montant, String motif) {
		super();
		this.localDateTime = localDateTime;
		this.montant = montant;
		this.motif = motif;
	};

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the localDateTime
	 */
	public Date getLocalDateTime() {
		return localDateTime;
	}

	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param localDateTime the localDateTime to set
	 */
	public void setLocalDateTime(Date localDateTime) {
		this.localDateTime = localDateTime;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", localDateTime=" + localDateTime + ", montant=" + montant + ", motif=" + motif
				+ ", compte=" + compte + "]";
	}

}
