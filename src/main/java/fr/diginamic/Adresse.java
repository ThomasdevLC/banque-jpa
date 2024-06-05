package fr.diginamic;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
	 private Integer numero;
	 private String rue;
	 
	 @Column(name="code_postal")
	 private Integer codePostal;
	 
	 private String ville;
	 
	 
	public Adresse() {
	}
	
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}


	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}


	/**
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}


	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}


	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}


	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}


	
	 
	 
	 
}
