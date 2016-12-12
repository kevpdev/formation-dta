/**
 * 
 */
package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Classe Personne
 * 
 * @author ETY11
 * @since 12 déc. 2016
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom", length = 150, nullable = false)
	private String nom;
	@Column(name = "prenom", length = 150, nullable = false)
	private String prenom;
	@Column(name = "email", length = 255, nullable = true)
	private String email;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public Personne() {
		super();
	}

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 */
	public Personne(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	/**
	 * getter id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter nom
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * setter nom
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * getter prenom
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * setter prenom
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * getter email
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setter email
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
