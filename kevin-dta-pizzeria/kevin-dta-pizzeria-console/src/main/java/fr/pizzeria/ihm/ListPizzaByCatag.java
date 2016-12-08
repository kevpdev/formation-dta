package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

public class ListPizzaByCatag extends Option {

	public IhmUtil ihmUtil;

	public ListPizzaByCatag(IhmUtil ihmUtil) {
		this.setLibelle("5. Lister les pizzas group�es par cat�gorie");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() throws PizzaException, IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
			SQLException {

		List<Pizza> pizzas = ihmUtil.getPizzaDao().findAllPizzas();
		Map<CategoriePizza, List<Pizza>> map = pizzas.stream().collect(Collectors.groupingBy(Pizza::getCategPizza));
		map.forEach((key, value) -> {
			value.forEach(value2 -> {
				System.out.println(key + " : " + value2);
			});
		});
	}

	@Override
	public void libelleOption() {

	}

}
