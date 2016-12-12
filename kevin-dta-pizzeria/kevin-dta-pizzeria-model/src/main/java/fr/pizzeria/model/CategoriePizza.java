package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String nomCateg;

	public String getNomCateg() {
		return nomCateg;
	}

	void setNomCateg(String nomCateg) {
		this.setNomCateg(nomCateg);
	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param nomCateg
	 */
	CategoriePizza(String nomCateg) {
		this.nomCateg = nomCateg;
	}

	public String toString() {
		return getNomCateg();
	}

}
