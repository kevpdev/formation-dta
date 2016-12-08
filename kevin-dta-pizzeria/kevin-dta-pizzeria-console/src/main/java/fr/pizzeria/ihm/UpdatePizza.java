package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

public class UpdatePizza extends Option {

	public IhmUtil ihmUtil;

	public UpdatePizza(IhmUtil ihmUtil) {

		this.setLibelle("3. Mise � jour d'une pizza");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() throws PizzaException, IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
			SQLException {

		ListPizza listp = new ListPizza(ihmUtil);
		listp.executeOption();

		System.out.print("Veuillez saisir le code de la pizza � modifier: ");
		String codeAmodifier = ihmUtil.getScanner().next();

		Pizza pizzaAModifier = ihmUtil.getPizzaDao().getPizzaByCode(codeAmodifier);
		if (!(pizzaAModifier == null)) {

			System.out.print("Veuillez saisir le nouveau code: ");
			String code = ihmUtil.getScanner().next();

			System.out.print("Veuillez saisir le nouveau nom: ");
			String nom = ihmUtil.getScanner().next();

			System.out.print("Veuillez saisir le nouveau prix: ");
			double prix = ihmUtil.getScanner().nextDouble();

			System.out.println("Liste des cat�gories: ");
			List<CategoriePizza> listCateg = new ArrayList<>(Arrays.asList(CategoriePizza.values()));
			for (int i = 0; i < listCateg.size(); i++) {

				System.out.println(i + 1 + ". " + listCateg.get(i).toString());

			}

			System.out.print("Veuillez saisir le num�ro de la cat�gorie: ");
			int categ = ihmUtil.getScanner().nextInt();
			System.out.println(categ);
			Pizza pizza = new Pizza(pizzaAModifier.getId(), code, nom, prix, listCateg.get(categ - 1));
			System.out.println(
					ihmUtil.getPizzaDao().updatePizza(pizza) ? "Mise � jour �ffectu� !" : "Echec de la mise � jour!");

		} else {
			System.out.println("Aucune pizza trouv�e !");
		}

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());
	}

}
