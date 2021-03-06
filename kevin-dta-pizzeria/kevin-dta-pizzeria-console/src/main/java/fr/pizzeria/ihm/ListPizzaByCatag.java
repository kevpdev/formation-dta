package fr.pizzeria.ihm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

/**
 * Classe ListPizzaByCatag
 * 
 * @author ETY11
 *
 */
@Controller
public class ListPizzaByCatag extends Option {
	@Autowired
	public IhmUtil ihmUtil;

	public ListPizzaByCatag() {
		this.setLibelle("5. Lister les pizzas group�es par cat�gorie");
	}

	@Override
	public void executeOption() {

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
