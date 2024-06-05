package fr.diginamic;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {

	private String beneficiaire;

	public Virement() {
	}

	public Virement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return "Virement [beneficiaire=" + beneficiaire + "]";
	}

}
