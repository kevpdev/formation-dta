package fr.pizzeria.ihm;

public class ExitMenu extends Option {

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public ExitMenu() {
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
