/**
 * 
 */
package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.EJB;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY11
 * @since 22 déc. 2016
 */
public class PizzaService {

	@EJB
	private PizzaDao pizzaDao;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 22 déc. 2016
	 * @author ETY11
	 */
	public PizzaService() {

	}

	public List<Pizza> findAllPizzas() {

		return pizzaDao.findAllPizzas();
	}

	public boolean addPizza(Pizza pizza) {
		return pizzaDao.addPizza(pizza);
	}

	public boolean updatePizza(Pizza pizza) {
		return pizzaDao.updatePizza(pizza);
	}

	public Pizza getPizzaByCode(String code) {
		return pizzaDao.getPizzaByCode(code);
	}

	public void archivePizza(Pizza pizza) {
		pizzaDao.archivePizza(pizza);
	}

	public List<Pizza> findAllArchive() {

		return pizzaDao.findAllArchive();
	}

}
