package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import fr.pizzeria.tool.IhmUtil;

/**
 * Classe Menu
 * 
 * @author ETY11
 *
 */
@Controller
public class Menu {

	public String titre;
	@Autowired
	public IhmUtil ihmUtil;
	public Map<Integer, Option> options = new HashMap<>();
	private Logger LOGGER = Logger.getLogger(Menu.class.getName());
	@Autowired
	private AnnotationConfigApplicationContext context;

	public Menu() {
		super();
	}

	@PostConstruct
	public void init() {

		this.options.put(0, context.getBean(ListPizza.class));
		this.options.put(1, context.getBean(AddPizza.class));
		this.options.put(2, context.getBean(UpdatePizza.class));
		this.options.put(3, context.getBean(DeletePizza.class));
		this.options.put(4, context.getBean(ListPizzaByCatag.class));
		this.options.put(5, context.getBean(PizzaTarifMax.class));
		this.options.put(6, context.getBean(ImportPizza.class));
		this.options.put(7, new ExitMenu());

	}

	// public Menu(String titre, IhmUtil ihmUtil) {
	// super();
	// this.titre = titre;
	// this.options.put(0, new ListPizza(ihmUtil));
	// this.options.put(1, new AddPizza(ihmUtil));
	// this.options.put(2, new UpdatePizza(ihmUtil));
	// this.options.put(3, new DeletePizza(ihmUtil));
	// this.options.put(4, new ListPizzaByCatag(ihmUtil));
	// this.options.put(5, new PizzaTarifMax(ihmUtil));
	// this.options.put(6, new ImportPizza(ihmUtil));
	// this.options.put(7, new ExitMenu());
	//
	// this.ihmUtil = ihmUtil;
	// }

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

		if (action < 8) {

			this.options.get(action - 1).executeOption();

			start();

		} else if (action == 99) {

			this.options.get(7).executeOption();
		}

	}

	public void start() {
		display();
		action();
	}

}
