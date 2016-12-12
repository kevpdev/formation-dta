package fr.pizzeria.ihm;

import java.util.Comparator;
import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

/**
 * Classe PizzaTarifMax
 * 
 * @author ETY11
 *
 */
public class PizzaTarifMax extends Option {

	public IhmUtil ihmUtil;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param ihmUtil
	 */
	public PizzaTarifMax(IhmUtil ihmUtil) {
		this.setLibelle("6. Afficher la pizza au tarif le plus �lev�");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() {

		List<Pizza> pizzas = ihmUtil.getPizzaDao().findAllPizzas();
		Pizza pizzaMax = pizzas.stream().max(Comparator.comparing(Pizza::getPrix)).get();
		System.out.println(pizzaMax);

	}

	@Override
	public void libelleOption() {

	}

}
