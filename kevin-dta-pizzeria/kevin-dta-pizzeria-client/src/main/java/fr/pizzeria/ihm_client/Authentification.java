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
import fr.pizzeria.ihm.Option;
import fr.pizzeria.tool.IhmUtil;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
public class Authentification extends Option {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public Authentification(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("2. Se connecter");
	}

	@Override
	public void executeOption() {
		System.out.print("email : ");
		String email = ihmUtil.getScanner().nextLine();
		System.out.print("mode de passe : ");
		String motDePasse = ihmUtil.getScanner().nextLine();

		if (ihmUtil.getClientdao().login(email, motDePasse) != null) {
			System.out.println("authentification reussi !!!!");
			displayMenu();
		} else {
			System.out.println("echec !!!!");
		}

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());

	}

	/**
	 * getter ihmUtil
	 * 
	 * @return the ihmUtil
	 */
	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	/**
	 * setter ihmUtil
	 * 
	 * @param ihmUtil
	 *            the ihmUtil to set
	 */
	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

	public void displayMenu() {
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
			MenuClient menu = new MenuClient("***** Menu Pizzeria *****", ihmUtil);
			menu.start();

			sc.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			throw new PizzaException(e);
		}
	}

}
