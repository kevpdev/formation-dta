package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.TypeTriPizza;
import fr.pizzeria.tool.IhmUtil;

public class ListPizza extends Option {

	public IhmUtil ihmUtil;
	public TypeTriPizza ttp;

	public ListPizza(IhmUtil ihmUtil) {
		this.setLibelle("1. Liste des pizza");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() {
		ihmUtil.getPizzaDao().findAllPizzas();
		List<Pizza> pizzas = ihmUtil.getPizzaDao().findAllPizzas();

		pizzas.forEach(System.out::println);

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());

	}

}
