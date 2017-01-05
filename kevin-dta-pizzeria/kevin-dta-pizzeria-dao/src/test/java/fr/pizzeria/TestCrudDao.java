package fr.pizzeria;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestDaoConfig.class)
public class TestCrudDao {

	@Autowired
	@Qualifier("getPizzaDaoTest")
	private PizzaDao pizzadao;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testfindAll() {

		Assert.assertTrue(0 < pizzadao.findAllPizzas().size());
		Logger.getLogger(getClass().getName()).info("taille de la liste : " + pizzadao.findAllPizzas().size());

	}

	@Test
	public void testAddPizza() {
		Logger.getLogger(getClass().getName()).info("categorie pizza : " + CategoriePizza.POISSON);
		Pizza p = new Pizza("PTEST" + new java.util.Date().getTime(), "pizzaTest", 9.99, CategoriePizza.POISSON,
				"test");
		Assert.assertTrue(pizzadao.addPizza(p));
	}

}
