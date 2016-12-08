package fr.pizzeria.ihm;

import java.util.Comparator;
import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

public class PizzaTarifMax extends Option {

	public IhmUtil ihmUtil;

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
