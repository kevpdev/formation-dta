package fr.pizzeria.ihm;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.TypeTriPizza;

/**
 * Classe ListPizza
 * 
 * @author ETY11
 *
 */
@Controller
public class ListPizza extends Option {
	@Autowired
	private PizzaDao pizzadao;
	private TypeTriPizza ttp;

	public ListPizza() {

	}

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param ihmUtil
	 */
	// public ListPizza(IhmUtil ihmUtil) {
	// this.setLibelle("1. Liste des pizza");
	// this.ihmUtil = ihmUtil;
	// }

	@PostConstruct
	public void init() {
		this.setLibelle("1. Liste des pizza");
	}

	@Override
	public void executeOption() {
		List<Pizza> pizzas = pizzadao.findAllPizzas();
		pizzas.forEach(System.out::println);

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());

	}

}
