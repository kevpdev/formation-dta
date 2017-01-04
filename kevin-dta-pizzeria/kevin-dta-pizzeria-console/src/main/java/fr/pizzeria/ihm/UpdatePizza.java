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
 * Classe UpdatePizza
 * 
 * @author ETY11
 *
 */
@Controller
public class UpdatePizza extends Option {
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
	 */
	public UpdatePizza() {

		this.setLibelle("3. Mise � jour d'une pizza");

	}

	@Override
	public void executeOption() {

		listp.executeOption();

		System.out.print("Veuillez saisir le code de la pizza � modifier: ");
		String codeAmodifier = sc.next();

		Pizza pizzaAModifier = pizzadao.getPizzaByCode(codeAmodifier);
		if (!(pizzaAModifier == null)) {

			System.out.print("Veuillez saisir le nouveau code: ");
			String code = sc.next();

			System.out.print("Veuillez saisir le nouveau nom: ");
			String nom = sc.next();

			System.out.print("Veuillez saisir le nouveau prix: ");
			double prix = sc.nextDouble();

			System.out.println("Liste des cat�gories: ");
			List<CategoriePizza> listCateg = new ArrayList<>(Arrays.asList(CategoriePizza.values()));
			for (int i = 0; i < listCateg.size(); i++) {

				System.out.println(i + 1 + ". " + listCateg.get(i).toString());

			}

			System.out.print("Veuillez saisir le num�ro de la cat�gorie: ");
			int categ = sc.nextInt();
			System.out.println(categ);
			Pizza pizza = new Pizza(pizzaAModifier.getId(), code, nom, prix, listCateg.get(categ - 1));
			System.out.println(pizzadao.updatePizza(pizza) ? "Mise � jour �ffectu� !" : "Echec de la mise � jour!");

		} else {
			System.out.println("Aucune pizza trouv�e !");
		}

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());
	}

}
