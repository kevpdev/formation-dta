package fr.pizzeria.model;

public class Pizza {
	
	public int id;
	public String code;
	public String nom;
	public double prix;
	public static int nbPizzas;
	
	
	public Pizza(int id, String code, String nom, double prix) {
		super();
		nbPizzas++;
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public static int getNbPizzas() {
		return nbPizzas;
	}


	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}


	@Override
	public String toString() {
		return "" + id + ") " + code + "-> " + nom + " (" + prix + "�)";
	}
	
	

}
