package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedQueries({ @NamedQuery(name = "pizza.findAll", query = "SELECT p FROM Pizza p"),
		@NamedQuery(name = "pizza.findPizzaByCode", query = "SELECT p FROM Pizza p WHERE p.code = :code") })

@Table(name = "pizza")
public class Pizza {

	@ToString
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ToString
	@Column(name = "reference", unique = true)
	private String code;
	@ToString
	@Column(name = "libelle")
	private String nom;
	@ToString
	private Double prix;
	@Enumerated(EnumType.STRING)
	@Column(name = "categ_pizza")
	@ToString
	private CategoriePizza categPizza;
	@Transient
	public static int nbPizzas;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public Pizza() {

	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, Double prix) {
		super();

		this.setId(nbPizzas);
		this.setCode(code);
		this.setNom(nom);
		this.setPrix(prix);
		nbPizzas++;
	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categ
	 */
	public Pizza(String code, String nom, Double prix, CategoriePizza categ) {
		this(code, nom, prix);
		nbPizzas++;
		this.setCategPizza(categ);
	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(Integer id, String code, String nom, Double prix) {
		this(code, nom, prix);
		nbPizzas++;
		this.setId(id);

	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categ
	 */
	public Pizza(Integer id, String code, String nom, Double prix, CategoriePizza categ) {
		this(id, code, nom, prix);

		nbPizzas++;
		this.setCategPizza(categ);

	}

	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}

	public CategoriePizza getCategPizza() {
		return categPizza;
	}

	public void setCategPizza(CategoriePizza categPizza) {
		this.categPizza = categPizza;
	}

	@Override
	public String toString() {
		return code + "-> " + nom + " (" + prix + "�) Categorie : " + categPizza;
	}

	public String toStringFile() {

		return getId() + ";" + getCode() + ";" + getNom() + ";" + getPrix() + ";" + getCategPizza() + ";";
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder(17, 37).append(id).append(code).append(nom).append(prix).append(categPizza)
				.toHashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza pizza = (Pizza) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(id, pizza.id).append(code, pizza.code)
				.append(nom, pizza.nom).append(prix, pizza.prix).append(categPizza, pizza.categPizza).isEquals();

	}

}
