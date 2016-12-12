package fr.pizzeria.ihm;

public class ExistMenu extends Option {
	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public ExistMenu() {
		this.setLibelle("99. Quittez l'application");
	}

	@Override
	public void executeOption() {

		System.out.println("Aurevoir");

		System.exit(0);
	}

	@Override
	public void libelleOption() {
	}

}
