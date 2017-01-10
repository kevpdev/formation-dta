package fr.pizzeria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	@Qualifier("pizzaDaoRepo")
	PizzaDao pizzadao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listPizza() {
		ModelAndView modelAndView = new ModelAndView();
		List<Pizza> pizzas = pizzadao.findAllPizzas();
		modelAndView.addObject("pizzas", pizzas);
		modelAndView.setViewName("listPizza");
		return modelAndView;

	}
}
