package fr.pizzeria.excepetion;

public class PizzaException extends RuntimeException {

	/**
	 * Classe PizzaException
	 */
	private static final long serialVersionUID = 1L;

	public PizzaException() {
		super();
	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public PizzaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param arg0
	 * @param arg1
	 */
	public PizzaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param arg0
	 */
	public PizzaException(String arg0) {
		super(arg0);
	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param arg0
	 */
	public PizzaException(Throwable arg0) {
		super(arg0);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
