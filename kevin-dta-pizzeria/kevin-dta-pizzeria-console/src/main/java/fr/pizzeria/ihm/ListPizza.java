package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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
	public void executeOption()
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		ihmUtil.getPizzaDao().findAllPizzas();
		List<Pizza> pizzas = ihmUtil.getPizzaDao().findAllPizzas();

		pizzas.forEach(System.out::println);

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());

	}

}
