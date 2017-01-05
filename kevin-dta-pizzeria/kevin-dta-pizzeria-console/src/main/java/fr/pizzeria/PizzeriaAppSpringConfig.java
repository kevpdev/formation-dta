package fr.pizzeria;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJdbcFactory;

@Configuration
@ComponentScan("fr.pizzeria.*")
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner getScanner() {

		return new Scanner(System.in).useLocale(Locale.US);
	}

	@Bean
	public PizzaDao getPizzaDao() {
		return new PizzaDaoJdbcFactory();
	}

	@Bean
	public AnnotationConfigApplicationContext getContextAction() {

		return new AnnotationConfigApplicationContext(this.getClass());
	}

}
