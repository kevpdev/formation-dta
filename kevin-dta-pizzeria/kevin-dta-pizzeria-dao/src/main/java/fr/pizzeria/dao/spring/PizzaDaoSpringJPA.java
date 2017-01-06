/**
 * 
 */
package fr.pizzeria.dao.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY11
 * @since 6 janv. 2017
 */
@Repository
@Transactional
public class PizzaDaoSpringJPA implements PizzaDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#findAllPizzas()
	 * 
	 * @return
	 */
	@Override
	public List<Pizza> findAllPizzas() {

		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAllNoArchive", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#addPizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
	@Override
	public boolean addPizza(Pizza pizza) {

		pizza.setId(null);
		em.persist(pizza);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#updatePizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#deletePizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
	@Override
	public boolean deletePizza(Pizza pizza) {
		Pizza pizzaDelete = em.find(Pizza.class, pizza.getId());
		if (pizzaDelete != null) {
			em.remove(pizzaDelete);
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#getPizzaByCode(java.lang.String)
	 * 
	 * @param code
	 * 
	 * @return
	 */
	@Override
	public Pizza getPizzaByCode(String code) {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findPizzaByCode", Pizza.class);
		query.setParameter("code", code.toString());
		Pizza pizza = query.getResultList().get(0);

		return pizza;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#getPizzaByPizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#archivePizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 */
	@Override
	public void archivePizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#findAllArchive()
	 * 
	 * @return
	 */
	@Override
	public List<Pizza> findAllArchive() {
		// TODO Auto-generated method stub
		return null;
	}

}
