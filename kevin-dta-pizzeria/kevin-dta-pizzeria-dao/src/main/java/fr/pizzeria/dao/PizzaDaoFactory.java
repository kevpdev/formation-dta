package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

/**
 * Interface PizzaDaoFactory
 * 
 * @author ETY11
 *
 */
public interface PizzaDaoFactory {

	/**
	 * 
	 * @return List<Pizza>
	 * @throws PizzaException
	 */
	List<Pizza> findAllPizzas();

	/**
	 * 
	 * @param pizza
	 * @return boolean
	 * @throws PizzaException
	 */
	boolean addPizza(Pizza pizza);

	/**
	 * 
	 * @param pizza
	 * @return boolean
	 * @throws PizzaException
	 */
	boolean updatePizza(Pizza pizza);

	/**
	 * 
	 * @param pizza
	 * @return boolean
	 * @throws PizzaException
	 */
	boolean deletePizza(Pizza pizza);

	/**
	 * 
	 * @param code
	 * @return Pizza
	 * @throws PizzaException
	 */
	Pizza getPizzaByCode(Object code);

	/**
	 * 
	 * @param pizza
	 * @return Pizza
	 * @throws PizzaException
	 */
	Pizza getPizzaByPizza(Pizza pizza);

	/**
	 * 
	 * @return boolean
	 * @throws PizzaException
	 */
	default boolean importPizza() {
		throw new PizzaException("pas d'implémentation");
	}

}
