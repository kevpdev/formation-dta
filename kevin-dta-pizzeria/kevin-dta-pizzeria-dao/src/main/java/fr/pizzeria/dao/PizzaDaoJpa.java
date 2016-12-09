package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements PizzaDaoFactory {

	private EntityManagerFactory emf;

	public PizzaDaoJpa() {

		setEmf(Persistence.createEntityManagerFactory("kevin-dta-pizzeria-console"));

	}

	@Override
	public List<Pizza> findAllPizzas() throws PizzaException {

		EntityManager em = getEmf().createEntityManager();
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAll", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		return pizzas;
	}

	@Override
	public boolean addPizza(Pizza pizza) throws PizzaException {

		EntityManager em = getEmf().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		pizza.setId(null);
		em.persist(pizza);
		et.commit();

		return true;
	}

	@Override
	public boolean updatePizza(Pizza pizza) throws PizzaException {
		EntityManager em = getEmf().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Pizza pizzaUpdate = em.find(Pizza.class, pizza.getId());

		if (pizzaUpdate != null) {
			pizzaUpdate.setCode(pizza.getCode());
			pizzaUpdate.setNom(pizza.getNom());
			pizzaUpdate.setPrix(pizza.getPrix());
			pizzaUpdate.setCategPizza(pizza.getCategPizza());
			et.commit();
			return true;
		}

		return false;
	}

	@Override
	public boolean deletePizza(Pizza pizza) throws PizzaException {

		EntityManager em = getEmf().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Pizza pizzaDelete = em.find(Pizza.class, pizza.getId());

		if (pizzaDelete != null) {
			em.remove(pizzaDelete);
			et.commit();
			return true;
		}

		return false;
	}

	@Override
	public Pizza getPizzaByCode(Object code) throws PizzaException {
		EntityManager em = getEmf().createEntityManager();
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findPizzaByCode", Pizza.class);
		query.setParameter("code", code.toString());
		Pizza pizza = query.getResultList().get(0);

		return pizza;
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) throws PizzaException {
		EntityManager em = getEmf().createEntityManager();
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findPizzaByCode", Pizza.class);
		query.setParameter("code", pizza.getCode());
		Pizza pizza2 = query.getResultList().get(0);

		return pizza2;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
