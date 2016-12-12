/**
 * 
 */
package fr.pizzeria.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "num_commande", length = 200, nullable = false)
	private String numCommande;
	@Column(name = "statut", length = 50, nullable = false)
	private String statut;
	@Column(name = "date_commande", nullable = false)
	private Date dateCommande;
	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private Set<Pizza> pizzas;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public Commande() {
		super();
	}

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param id
	 * @param numCommande
	 * @param statut
	 * @param dateCommande
	 * @param livreur
	 * @param client
	 */
	public Commande(int id, String numCommande, String statut, Date dateCommande, Livreur livreur, Client client) {
		super();
		this.id = id;
		this.numCommande = numCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.livreur = livreur;
		this.client = client;
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
	 * getter numCommande
	 * 
	 * @return the numCommande
	 */
	public String getNumCommande() {
		return numCommande;
	}

	/**
	 * setter numCommande
	 * 
	 * @param numCommande
	 *            the numCommande to set
	 */
	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}

	/**
	 * getter statut
	 * 
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * setter statut
	 * 
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * getter dateCommande
	 * 
	 * @return the dateCommande
	 */
	public Date getDateCommande() {
		return dateCommande;
	}

	/**
	 * setter dateCommande
	 * 
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * getter livreur
	 * 
	 * @return the livreur
	 */
	public Livreur getLivreur() {
		return livreur;
	}

	/**
	 * setter livreur
	 * 
	 * @param livreur
	 *            the livreur to set
	 */
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	/**
	 * getter client
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * setter client
	 * 
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
