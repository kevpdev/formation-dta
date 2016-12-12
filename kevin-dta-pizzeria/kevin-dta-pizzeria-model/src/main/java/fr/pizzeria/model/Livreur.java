/**
 * 
 */
package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
@Entity
public class Livreur extends Personne {

	@OneToMany(mappedBy = "livreur")
	Set<Commande> commandes;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public Livreur() {

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
	public Livreur(int id, String nom, String prenom, String email) {
		super(id, nom, prenom, email);

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
	public Livreur(int id, String nom, String prenom, String email, Set<Commande> commandes) {
		super(id, nom, prenom, email);
		this.commandes = commandes;

	}

}
