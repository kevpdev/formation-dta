package fr.pizzeria.excepetion;

public class AddPizzaException extends PizzaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddPizzaException() {
		super();
	}

	@Override
	public String getMessage() {
		return "Erreur Ajout : " + super.getMessage();
	}

}
