package fr.pizzeria.dao.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoAspect {

	@Pointcut("execution(* fr.pizzeria.dao.PizzaDao.addPizza(..))")
	public void checkSavePizza() {
	}

	@Pointcut("execution(* fr.pizzeria.dao.PizzaDao.*(..))")
	public void methodDao() {

	}

}
