package fr.pizzeria.excepetion;

/**
 * Classe DeletePizzaException
 * 
 * @author ETY11
 *
 */
public class DeletePizzaException extends PizzaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Erreur Suppression : " + super.getMessage();
	}

}
