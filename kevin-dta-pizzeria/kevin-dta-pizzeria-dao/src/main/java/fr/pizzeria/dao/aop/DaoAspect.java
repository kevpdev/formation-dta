package fr.pizzeria.dao.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DaoAspect {

	@Pointcut("execution(* fr.pizzeria.dao.*(..))")
	public void cruddao() {

	}

}
