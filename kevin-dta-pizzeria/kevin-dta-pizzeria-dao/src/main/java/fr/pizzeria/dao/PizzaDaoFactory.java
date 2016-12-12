package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDaoFactory {

	/**
	 * 
	 * @return List<Pizza>
	 * @throws PizzaException
	 */
	List<Pizza> findAllPizzas() throws PizzaException;

	/**
	 * 
	 * @param pizza
	 * @return boolean
	 * @throws PizzaException
	 */
	boolean addPizza(Pizza pizza) throws PizzaException;

	/**
	 * 
	 * @param pizza
	 * @return boolean
	 * @throws PizzaException
	 */
	boolean updatePizza(Pizza pizza) throws PizzaException;

	/**
	 * 
	 * @param pizza
	 * @return boolean
	 * @throws PizzaException
	 */
	boolean deletePizza(Pizza pizza) throws PizzaException;

	/**
	 * 
	 * @param code
	 * @return Pizza
	 * @throws PizzaException
	 */
	Pizza getPizzaByCode(Object code) throws PizzaException;

	/**
	 * 
	 * @param pizza
	 * @return Pizza
	 * @throws PizzaException
	 */
	Pizza getPizzaByPizza(Pizza pizza) throws PizzaException;

	/**
	 * 
	 * @return boolean
	 * @throws PizzaException
	 */
	default boolean importPizza() throws PizzaException {
		throw new PizzaException("pas d'implémentation");
	}

}
