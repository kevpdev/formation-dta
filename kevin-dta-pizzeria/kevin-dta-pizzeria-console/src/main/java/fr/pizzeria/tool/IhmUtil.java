package fr.pizzeria.tool;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.ClientDao;
import fr.pizzeria.dao.PizzaDao;

@Controller
public class IhmUtil {

	@Autowired
	private Scanner scanner;
	@Autowired
	private PizzaDao pizzaDao;
	private ClientDao clientdao;
	private final String filename = "pizzas.txt";

	public IhmUtil() {

	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param scanner
	 * @param pizzaDao
	 */
	public IhmUtil(Scanner scanner, PizzaDao pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param scanner
	 * @param pizzaDao
	 * @param clientdao
	 */
	public IhmUtil(Scanner scanner, PizzaDao pizzaDao, ClientDao clientdao) {
		this(scanner, pizzaDao);
		this.setClientdao(clientdao);
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

	/**
	 * getter clientdao
	 * 
	 * @return the clientdao
	 */
	public ClientDao getClientdao() {
		return clientdao;
	}

	/**
	 * setter clientdao
	 * 
	 * @param clientdao
	 *            the clientdao to set
	 */
	public void setClientdao(ClientDao clientdao) {
		this.clientdao = clientdao;
	}

}