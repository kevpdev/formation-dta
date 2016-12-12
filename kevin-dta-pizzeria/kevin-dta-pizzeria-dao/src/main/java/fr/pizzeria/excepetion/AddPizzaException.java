package fr.pizzeria.excepetion;

/*
 * Classe AddPizzaException
 */
public class AddPizzaException extends PizzaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public AddPizzaException() {
		super();
	}

	@Override
	public String getMessage() {
		return "Erreur Ajout : " + super.getMessage();
	}

}
