package fr.pizzeria.tool;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

public class IhmUtil {

	private final Scanner scanner;
	private final PizzaDao pizzaDao;
	private final String filename = "pizzas.txt";

	public IhmUtil(final Scanner scanner, final PizzaDao pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

	public String getFilename() {
		return filename;
	}

}