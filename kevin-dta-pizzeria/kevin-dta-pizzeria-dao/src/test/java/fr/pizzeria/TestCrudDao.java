package fr.pizzeria;

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
	@Qualifier("pizzaDaoSpringJPA")
	private PizzaDao pizzadao;

	@Test
	public void testFindAll() {
		// fail("Not yet implemented");
		Assert.assertTrue(0 < pizzadao.findAllPizzas().size());
		Logger.getLogger(getClass().getName()).info("taille de la liste : " + pizzadao.findAllPizzas().size());

	}

	@Test
	public void testFindByCode() {
		String code = pizzadao.getPizzaByCode("REI").getCode();
		Logger.getLogger(getClass().getName()).info("code : " + code);
		Assert.assertEquals("REI", code);
	}

	@Test
	public void testAddPizza() {

		Logger.getLogger(getClass().getName()).info("categorie pizza : " + CategoriePizza.POISSON);
		Pizza p = new Pizza("PTEST" + new java.util.Date().getTime(), "pizzaTest", 9.99, CategoriePizza.POISSON,
				"test");
		Assert.assertTrue(pizzadao.addPizza(p));
	}

	@Test
	public void testUpdatePizza() {

		Pizza p = pizzadao.getPizzaByCode("MAR");
		p.setCode("PMAR");
		p.setNom("margerita");
		p.setPrix(9.99);
		p.setCategPizza(CategoriePizza.POISSON);
		p.setUrl("margerita.jpg");
		Assert.assertTrue(pizzadao.updatePizza(p));
	}

	@Test
	public void testDeletePizza() {

		Pizza p = pizzadao.getPizzaByCode("FRO");

		Assert.assertTrue(pizzadao.deletePizza(p));
	}

}
