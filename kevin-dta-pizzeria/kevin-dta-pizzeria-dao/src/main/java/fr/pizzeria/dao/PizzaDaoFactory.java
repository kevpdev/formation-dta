package fr.pizzeria.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDaoFactory {

	List<Pizza> findAllPizzas() throws IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException;

	boolean addPizza(Pizza pizza) throws PizzaException, FileNotFoundException, IllegalArgumentException,
			IllegalAccessException, IOException, SQLException;

	boolean updatePizza(Pizza pizza) throws PizzaException, FileNotFoundException, SQLException;

	boolean deletePizza(Pizza pizza) throws PizzaException, FileNotFoundException, SQLException;

	Pizza getPizzaByCode(Object code) throws SQLException;

	Pizza getPizzaByPizza(Pizza pizza) throws SQLException;

	// public void savePizzas(String filename) throws FileNotFoundException;

}
