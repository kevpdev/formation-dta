package fr.pizzeria.ihm;

public abstract class Option {

	public String libelle;

	/**
	 * 
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * execute une action
	 */
	public abstract void executeOption();

	/**
	 * affiche le titre de l'action
	 */
	public abstract void libelleOption();

}
