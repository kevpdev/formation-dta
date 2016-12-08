package fr.pizzeria.excepetion;

public class AddPizzaException extends PizzaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddPizzaException() {
		super();
	}

	public AddPizzaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AddPizzaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AddPizzaException(String arg0) {
		super(arg0);
	}

	public AddPizzaException(Throwable arg0) {
		super(arg0);
	}

	@Override
	public String getMessage() {
		return "Erreur Ajout : " + super.getMessage();
	}

}
