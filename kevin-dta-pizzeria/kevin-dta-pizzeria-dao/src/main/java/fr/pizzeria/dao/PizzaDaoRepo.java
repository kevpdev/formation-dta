/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Pizza;

/**
 * @author ETY11
 * @since 6 janv. 2017
 */
@Repository
public class PizzaDaoRepo implements PizzaDao {

	@Autowired
	private PizzaRepository pizzaRepo;

	@Override
	public List<Pizza> findAllPizzas() {

		return pizzaRepo.findAll();

	}

	@Override
	public boolean addPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pizza getPizzaByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archivePizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pizza> findAllArchive() {
		// TODO Auto-generated method stub
		return null;
	}

}
