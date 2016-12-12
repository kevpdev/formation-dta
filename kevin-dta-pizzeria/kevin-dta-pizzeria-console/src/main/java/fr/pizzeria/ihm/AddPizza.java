package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

public class AddPizza extends Option {

	public IhmUtil ihmUtil;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param ihmUtil
	 */
	public AddPizza(IhmUtil ihmUtil) {
		this.setLibelle("2. Ajouter une pizza");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() {

		System.out.println("Ajout d'une nouvelle pizza");

		System.out.print("Veuillez saisir le code: ");
		String code = ihmUtil.getScanner().next();

		System.out.print("Veuillez saisir le nom: ");
		String nom = ihmUtil.getScanner().next();

		System.out.print("Veuillez saisir le prix: ");
		double prix = ihmUtil.getScanner().nextDouble();

		System.out.println("Liste des cat�gories: ");
		List<CategoriePizza> listCateg = new ArrayList<>(Arrays.asList(CategoriePizza.values()));

		for (int i = 0; i < listCateg.size(); i++) {

			System.out.println(i + 1 + ". " + listCateg.get(i).toString());

		}

		System.out.print("Veuillez saisir le num�ro de la cat�gorie: ");
		int categ = ihmUtil.getScanner().nextInt();

		Pizza pizza = new Pizza(0, code, nom, prix, listCateg.get(categ - 1));
		System.out.println(ihmUtil.getPizzaDao().addPizza(pizza) ? "Ajout �ffectu� !" : "Echec de l'ajout !");

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());

	}

}
