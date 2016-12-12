/**
 * 
 */
package fr.pizzeria.ihm_client;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.ClientDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.tool.IhmUtil;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
public class EcranPrincipalClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String pizzaDaoImpl = bundle.getString("pizza.dao.impl");
		String clientDaoImpl = bundle.getString("client.dao.impl");
		PizzaDao pizzaDaofactory;
		ClientDao clientDaofactory;
		try {

			pizzaDaofactory = (PizzaDao) Class.forName(pizzaDaoImpl).newInstance();
			clientDaofactory = (ClientDao) Class.forName(clientDaoImpl).newInstance();

			Scanner sc = new Scanner(System.in).useLocale(Locale.US);

			IhmUtil ihmUtil;
			ihmUtil = new IhmUtil(sc, pizzaDaofactory, clientDaofactory);
			AccueilClient menu = new AccueilClient("***** Pizzeria Administration *****", ihmUtil);
			menu.start();

			sc.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			throw new PizzaException(e);
		}

	}

}
