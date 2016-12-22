package fr.pizzeria.admin.service;

import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJpaFactory;

public class DaoProducer {

	@Produces
	public PizzaDao getPizzaDao() {
		return new PizzaDaoJpaFactory();
	}

}
