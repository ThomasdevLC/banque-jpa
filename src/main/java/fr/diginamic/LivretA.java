package fr.diginamic;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class LivretA extends Compte {

	private double taux;

	public LivretA() {
	}

	public LivretA(double taux) {
		super();
		this.taux = taux;
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}

}
