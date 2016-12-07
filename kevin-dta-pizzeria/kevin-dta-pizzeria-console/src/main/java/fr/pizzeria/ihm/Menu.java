package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.tool.IhmUtil;

public class Menu {

	public String titre;
	public IhmUtil ihmUtil;
	// public Option [] options = new Option[5];
	public Map<Integer, Option> options = new HashMap<>();
	private Logger LOGGER = Logger.getLogger(DeletePizza.class.getName());

	public Menu() {
		super();
	}

	public Menu(String titre, IhmUtil ihmUtil) {
		super();
		this.titre = titre;
		this.options.put(0, new ListPizza(ihmUtil));
		this.options.put(1, new AddPizza(ihmUtil));
		this.options.put(2, new UpdatePizza(ihmUtil));
		this.options.put(3, new DeletePizza(ihmUtil));
		this.options.put(4, new ListPizzaByCatag(ihmUtil));
		this.options.put(5, new PizzaTarifMax(ihmUtil));
		this.options.put(6, new ExistMenu());

		this.ihmUtil = ihmUtil;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setOptions(HashMap<Integer, Option> options) {
		this.options = options;
	}

	public void display() {

		System.out.println(this.titre);

		// for (Option option : options) {
		// System.out.println(option.libelle);
		// }

		// for (Map.Entry<Integer, Option> entree : options.entrySet()) {
		// System.out.println(entree.getValue().libelle);
		// }

		options.forEach((key, value) -> {
			System.out.println(value.getLibelle());
		});

	}

	public void action() throws InvocationTargetException, NoSuchMethodException, SecurityException {

		Integer action = 0;
		boolean notInteger = true;

		do {

			try {
				System.out.print("Votre choix : ");
				Scanner sc = new Scanner(System.in);
				action = sc.nextInt();
				notInteger = false;

			} catch (InputMismatchException e) {
				LOGGER.info(e.getMessage() + " !!!!!!!!!!! Seulement un nombre entier !!!!!!!!!");
			}

		} while (notInteger);

		try {
			if (action < 7) {

				this.options.get(action - 1).executeOption();

				start();

			} else if (action == 99) {

				this.options.get(4).executeOption();
			}
		} catch (PizzaException | IOException | IllegalArgumentException | IllegalAccessException
				| InstantiationException e) {

			LOGGER.info(e.getMessage());

		}

	}

	public void start() throws InvocationTargetException, NoSuchMethodException, SecurityException {
		display();
		action();
	}

}
