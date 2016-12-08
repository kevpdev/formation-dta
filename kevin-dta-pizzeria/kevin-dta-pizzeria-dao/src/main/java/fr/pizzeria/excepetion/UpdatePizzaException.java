package fr.pizzeria.excepetion;

public class UpdatePizzaException extends PizzaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Erreur Mise � jour : " + super.getMessage();
	}

}
