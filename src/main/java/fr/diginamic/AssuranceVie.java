package fr.diginamic;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@DiscriminatorValue("A")
public class AssuranceVie extends Compte {

	@Temporal(TemporalType.DATE)
	@Column(name = "local_date")
	private Date localDate;

	private double taux;

	public AssuranceVie() {
	}

	public AssuranceVie(Date localDate, double taux) {
		super();
		this.localDate = localDate;
		this.taux = taux;
	}

	/**
	 * @return the localDate
	 */
	public Date getLocalDate() {
		return localDate;
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param localDate the localDate to set
	 */
	public void setLocalDate(Date localDate) {
		this.localDate = localDate;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "AssuranceVie [localDate=" + localDate + ", taux=" + taux + "]";
	}

}
