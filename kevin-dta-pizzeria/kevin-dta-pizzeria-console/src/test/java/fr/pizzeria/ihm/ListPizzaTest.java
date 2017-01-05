/**
 * 
 */
package fr.pizzeria.ihm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.SpringTestConfig;

/**
 * @author ETY11
 * @since 5 janv. 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = "application.xml")
@ContextConfiguration(classes = SpringTestConfig.class)
public class ListPizzaTest {

	@Autowired
	private ListPizza listPizza;

	@Test
	public void test() {
		Assert.assertEquals("1. Liste des pizza", listPizza.getLibelle());
	}

}
