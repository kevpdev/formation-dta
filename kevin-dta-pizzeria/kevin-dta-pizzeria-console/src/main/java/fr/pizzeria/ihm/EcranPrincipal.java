package fr.pizzeria.ihm;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.PizzeriaAppSpringConfig;
import fr.pizzeria.model.Pizza;

/**
 * Classe Ecran
 * 
 * @author ETY11
 *
 */
public class EcranPrincipal {

	public static void main(String[] args) {

		Pizza p1 = new Pizza();
		p1.setCode("MAR");

		Pizza p2 = new Pizza();
		p2.setCode("MAR");

		System.out.println("p1=p2 ? " + p1.equals(p2));

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("pizza.dao.impl");
		// IhmUtil ihmUtil;
		// ihmUtil = new IhmUtil(sc, daofactory);
		// Menu menu = new Menu("***** Pizzeria Administration *****", ihmUtil);
		// menu.start();
		// PizzaDao daofactory;
		// try {

		// daofactory = (PizzaDao) Class.forName(daoImpl).newInstance();

		// context spring
		// try (ClassPathXmlApplicationContext contextApp = new
		// ClassPathXmlApplicationContext(daoImpl,
		// "application-config.xml"); Scanner sc =
		// contextApp.getBean(Scanner.class).useLocale(Locale.US);) {
		// contextApp.getBean(Menu.class).start();
		// ;
		//
		// }
		try (AnnotationConfigApplicationContext contextApp = new AnnotationConfigApplicationContext(
				PizzeriaAppSpringConfig.class); Scanner sc = contextApp.getBean(Scanner.class).useLocale(Locale.US);) {
			contextApp.getBean(Menu.class).setTitre("Bienvenue chez la pizzeria la Florentina !!!!");
			contextApp.getBean(Menu.class).start();

		}

	}

}
