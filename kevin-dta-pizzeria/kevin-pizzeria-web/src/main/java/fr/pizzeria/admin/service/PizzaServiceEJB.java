package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB implements PizzaDao {

	@PersistenceContext(unitName = "pizza-db")
	private EntityManager em;

	public PizzaServiceEJB() {

	}

	@Override
	public List<Pizza> findAllPizzas() {

		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAll", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		return pizzas;
	}

	@Override
	public boolean addPizza(Pizza pizza) {

		pizza.setId(null);
		em.persist(pizza);

		return true;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {

		Pizza pizzaUpdate = em.find(Pizza.class, pizza.getId());

		if (pizzaUpdate != null) {
			pizzaUpdate.setCode(pizza.getCode());
			pizzaUpdate.setNom(pizza.getNom());
			pizzaUpdate.setPrix(pizza.getPrix());
			pizzaUpdate.setCategPizza(pizza.getCategPizza());
			em.merge(pizzaUpdate);
			return true;
		}

		return false;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {

		Pizza pizzaDelete = em.find(Pizza.class, pizza.getId());

		if (pizzaDelete != null) {
			em.remove(pizzaDelete);
			return true;
		}

		return false;
	}

	@Override
	public Pizza getPizzaByCode(Object code) {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findPizzaByCode", Pizza.class);
		query.setParameter("code", code.toString());
		Pizza pizza = query.getResultList().get(0);

		return pizza;
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {

		return null;
	}

}
