package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * Classe DeletePizza
 * 
 * @author ETY11
 *
 */
@Controller
public class DeletePizza extends Option {
	@Autowired
	public Scanner sc;
	@Autowired
	private PizzaDao pizzadao;
	@Autowired
	public ListPizza listp;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param ihmUtil
	 */
	public DeletePizza() {

		this.setLibelle("4. Suppression d'une pizza");
	}

	@Override
	public void executeOption() {

		listp.executeOption();

		System.out.print("Veuillez saisir le code de la pizza �  supprimer: ");
		String codeASupprimer = sc.next();

		Pizza pizzaASup = pizzadao.getPizzaByCode(codeASupprimer);
		if (codeASupprimer != null) {

			System.out.println(pizzadao.deletePizza(pizzaASup) ? "Suppression �ffectu�" : "Echec de la suppression");

		} else {
			System.out.println("la pizza � supprimer n'existe pas !");
		}

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());
	}

}
