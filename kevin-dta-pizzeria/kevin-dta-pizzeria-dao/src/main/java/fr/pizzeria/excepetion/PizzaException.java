package fr.pizzeria.excepetion;

public class PizzaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PizzaException() {
		super();
	}

	public PizzaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PizzaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PizzaException(String arg0) {
		super(arg0);
	}

	public PizzaException(Throwable arg0) {
		super(arg0);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
