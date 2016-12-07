package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

public class PizzaTarifMax extends Option {

	public IhmUtil ihmUtil;

	public PizzaTarifMax(IhmUtil ihmUtil) {
		// TODO Auto-generated constructor stub
		this.setLibelle("6. Afficher la pizza au tarif le plus �lev�");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() throws PizzaException, IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		List<Pizza> pizzas = ihmUtil.getPizzaDao().findAllPizzas();
		Pizza pizzaMax = pizzas.stream().max(Comparator.comparing(Pizza::getPrix)).get();
		System.out.println(pizzaMax);

	}

	@Override
	public void libelleOption() {
		// TODO Auto-generated method stub

	}

}
