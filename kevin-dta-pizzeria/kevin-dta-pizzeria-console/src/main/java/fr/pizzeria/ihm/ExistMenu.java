package fr.pizzeria.ihm;

public class ExistMenu extends Option {

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
