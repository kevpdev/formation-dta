package fr.pizzeria.dao.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class PizzaGreffon {

	@Before("fr.pizzeria.dao.aop.DaoAspect.checkSavePizza()")
	public void valoriserCodePizza(JoinPoint jp) {

		Pizza pizza = null;
		Object[] tab = jp.getArgs();

		Logger.getLogger(getClass().getName()).info("tab argument joinpoint : " + tab);

		for (int i = 0; i < tab.length; i++) {
			if (tab[i] instanceof Pizza) {
				pizza = (Pizza) tab[i];
				Logger.getLogger(getClass().getName()).info("pizza en param : " + pizza);
			}
		}

		if ((pizza != null) && ("".equals(pizza.getCode()))) {
			if (!"".equals(pizza.getNom())) {
				String nouveauCode = pizza.getNom().substring(0, 3);
				pizza.setCode(nouveauCode);
			} else {
				pizza.setCode(new java.util.Date().getTime() + "");

			}
		}

		Logger.getLogger(getClass().getName()).info("pizza apres modif : " + pizza);
	}

}
