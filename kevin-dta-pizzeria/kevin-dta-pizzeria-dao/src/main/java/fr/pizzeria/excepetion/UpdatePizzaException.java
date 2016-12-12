package fr.pizzeria.excepetion;

/**
 * Classe UpdatePizzaException
 * 
 * @author ETY11
 *
 */
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
