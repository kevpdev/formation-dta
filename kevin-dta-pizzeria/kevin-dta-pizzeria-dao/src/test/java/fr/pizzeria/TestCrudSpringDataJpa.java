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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestDaoConfig.class)
public class TestCrudSpringDataJpa {

	@Autowired
	@Qualifier("pizzaDaoRepo")
	private PizzaDao pizzadao;

	@Test
	public void testFindAll() {
		// fail("Not yet implemented");
		Assert.assertTrue(0 < pizzadao.findAllPizzas().size());
		Logger.getLogger(getClass().getName()).info("taille de la liste : " + pizzadao.findAllPizzas().size());
		Logger.getLogger(getClass().getName()).info("contenu de la liste : " + pizzadao.findAllPizzas());

	}

}
