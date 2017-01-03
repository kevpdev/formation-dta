package fr.pizzeria.admin.service;

import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.ClientDao;
import fr.pizzeria.dao.ClientDaoJpaFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJpaFactory;

public class DaoProducer {

	@Produces
	public PizzaDao getPizzaDao() {
		return new PizzaDaoJpaFactory();
	}

	@Produces
	public ClientDao getClientDao() {
		return new ClientDaoJpaFactory();
	}

}
