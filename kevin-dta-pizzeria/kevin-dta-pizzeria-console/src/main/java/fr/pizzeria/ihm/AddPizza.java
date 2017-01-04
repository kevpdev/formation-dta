package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe AddPizza
 * 
 * @author ETY11
 *
 */
@Controller
public class AddPizza extends Option {

	@Autowired
	public Scanner sc;
	@Autowired
	private PizzaDao pizzadao;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param ihmUtil
	 */
	public AddPizza() {
		this.setLibelle("2. Ajouter une pizza");

	}

	@Override
	public void executeOption() {

		System.out.println("Ajout d'une nouvelle pizza");

		System.out.print("Veuillez saisir le code: ");
		String code = sc.next();

		System.out.print("Veuillez saisir le nom: ");
		String nom = sc.next();

		System.out.print("Veuillez saisir le prix: ");
		double prix = sc.nextDouble();

		System.out.println("Liste des cat�gories: ");
		List<CategoriePizza> listCateg = new ArrayList<>(Arrays.asList(CategoriePizza.values()));

		for (int i = 0; i < listCateg.size(); i++) {

			System.out.println(i + 1 + ". " + listCateg.get(i).toString());

		}

		System.out.print("Veuillez saisir le num�ro de la cat�gorie: ");
		int categ = sc.nextInt();

		Pizza pizza = new Pizza(0, code, nom, prix, listCateg.get(categ - 1));
		System.out.println(pizzadao.addPizza(pizza) ? "Ajout �ffectu� !" : "Echec de l'ajout !");

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());

	}

}
