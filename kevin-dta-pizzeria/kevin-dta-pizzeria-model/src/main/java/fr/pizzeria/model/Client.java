/**
 * 
 */
package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe Client
 * 
 * @author ETY11
 * @since 12 déc. 2016
 */
@Entity
public class Client extends Personne {
	@Column(name = "mot_de_passe", length = 255, nullable = false)
	private String motDePasse;
	@Column(name = "adresse", length = 255, nullable = false)
	private String adresse;
	@Column(name = "ville", length = 150, nullable = true)
	private String ville;
	@Column(name = "code_postal", length = 6, nullable = false)
	private String codePostal;
	@Column(name = "telephone", length = 15, nullable = true)
	private String telepone;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param motDePasse
	 * @param adresse
	 * @param ville
	 * @param codePostal
	 * @param telepone
	 */
	public Client(int id, String nom, String prenom, String email, String motDePasse, String adresse, String ville,
			String codePostal, String telepone) {
		super(id, nom, prenom, email);
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telepone = telepone;
	}

	/**
	 * getter motDePasse
	 * 
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * setter motDePasse
	 * 
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * getter adresse
	 * 
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * setter adresse
	 * 
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * getter ville
	 * 
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * setter ville
	 * 
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * getter codePostal
	 * 
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * setter codePostal
	 * 
	 * @param codePostal
	 *            the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * getter telepone
	 * 
	 * @return the telepone
	 */
	public String getTelepone() {
		return telepone;
	}

	/**
	 * setter telepone
	 * 
	 * @param telepone
	 *            the telepone to set
	 */
	public void setTelepone(String telepone) {
		this.telepone = telepone;
	}

}
