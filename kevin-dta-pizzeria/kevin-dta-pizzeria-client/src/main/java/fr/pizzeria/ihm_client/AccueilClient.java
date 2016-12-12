/**
 * 
 */
package fr.pizzeria.ihm_client;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import fr.pizzeria.ihm.ExitMenu;
import fr.pizzeria.ihm.Option;
import fr.pizzeria.tool.IhmUtil;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
public class AccueilClient {

	public String titre;
	public IhmUtil ihmUtil;
	public Map<Integer, Option> options = new HashMap<>();
	private Logger LOGGER = Logger.getLogger(AccueilClient.class.getName());

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param titre
	 * @param ihmUtil
	 * @param options
	 * @param lOGGER
	 */
	public AccueilClient(String titre, IhmUtil ihmUtil) {
		super();
		this.titre = titre;
		this.ihmUtil = ihmUtil;
		this.options.put(0, new Inscription(ihmUtil));
		this.options.put(1, new Authentification(ihmUtil));
		this.options.put(2, new ExitMenu());

	}

	public void display() {

		System.out.println(this.titre);

		options.forEach((key, value) -> {
			System.out.println(value.getLibelle());
		});

	}

	public void action() {

		Integer action = 0;
		boolean notInteger = true;

		do {
			System.out.print("Votre choix : ");
			Scanner sc = new Scanner(System.in);
			action = sc.nextInt();
			notInteger = false;

		} while (notInteger);

		if (action < 2) {

			this.options.get(action - 1).executeOption();

			start();

		} else if (action == 99) {

			this.options.get(2).executeOption();
		}

	}

	public void start() {
		display();
		action();
	}

}
