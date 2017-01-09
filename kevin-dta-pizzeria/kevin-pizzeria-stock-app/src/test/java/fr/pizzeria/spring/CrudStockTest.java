package fr.pizzeria.spring;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigStockTest.class)
public class CrudStockTest {

	@Test
	public void findAllTest() {
		fail("Not yet implemented");
	}

}
