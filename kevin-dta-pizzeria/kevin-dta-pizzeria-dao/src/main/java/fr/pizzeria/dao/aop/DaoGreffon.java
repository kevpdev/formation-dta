package fr.pizzeria.dao.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoGreffon {

	@Around("fr.pizzeria.dao.aop.DaoAspect.methodDao")
	public void saveTempsExecMethodDao() {

	}

}
