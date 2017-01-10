package fr.pizzeria.resources;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/rest/pizzas")
public class PizzaResources {
	@Autowired
	@Qualifier("pizzaDaoRepo")
	PizzaDao pizzadao;

	public PizzaResources() {

	}

	@PostConstruct
	public void init() {
		Pizza p = new Pizza();
		p.setCode("PMAR");
		p.setNom("margerita");
		p.setPrix(9.99);
		p.setCategPizza(CategoriePizza.SANS_VIANDE);
		p.setUrl("margerita.jpg");

		Pizza p2 = new Pizza();
		p2.setCode("PPEP");
		p2.setNom("peperoni");
		p2.setPrix(9.99);
		p2.setCategPizza(CategoriePizza.VIANDE);
		p2.setUrl("peperoni.jpg");

		pizzadao.addPizza(p);
		pizzadao.addPizza(p2);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Pizza> listPizzas() {

		List<Pizza> pizzas = pizzadao.findAllPizzas();
		return pizzas;

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void addPizza() {

		Pizza p = new Pizza();
		p.setCode("PMAR");
		p.setNom("margerita");
		p.setPrix(9.99);
		p.setCategPizza(CategoriePizza.POISSON);
		p.setUrl("margerita.jpg");
		p.setArchive(true);

		pizzadao.addPizza(p);
	}

}
