package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDaoFactory {

	List<Pizza> findAllPizzas() throws PizzaException;

	boolean addPizza(Pizza pizza) throws PizzaException;

	boolean updatePizza(Pizza pizza) throws PizzaException;

	boolean deletePizza(Pizza pizza) throws PizzaException;

	Pizza getPizzaByCode(Object code) throws PizzaException;

	Pizza getPizzaByPizza(Pizza pizza) throws PizzaException;

	// public void savePizzas(String filename) throws FileNotFoundException;

}
