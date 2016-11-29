package fr.pizzeria.tool;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class IhmUtil {

	private final Scanner scanner;
	private final IPizzaDao pizzaDao;
	private final String filename = "pizzas.txt";

	public IhmUtil(final Scanner scanner, final IPizzaDao pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public IPizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

	public String getFilename() {
		return filename;
	}

}