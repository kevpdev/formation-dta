package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private Double prix;
	private Double quantite;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 9 janv. 2017
	 * @author ETY11
	 * @param id
	 * @param nom
	 * @param prix
	 * @param quantite
	 */

	public Ingredient() {

	}

	public Ingredient(String nom, Double prix, Double quantite) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;

	}

	public Ingredient(int id, String nom, Double prix, Double quantite) {
		this(nom, prix, quantite);
		this.id = id;

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
	 * getter prix
	 * 
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * setter prix
	 * 
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * getter quantite
	 * 
	 * @return the quantite
	 */
	public Double getQuantite() {
		return quantite;
	}

	/**
	 * setter quantite
	 * 
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

}
