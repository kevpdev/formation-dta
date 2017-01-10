package fr.pizzeria.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.IngredientDao;
import fr.pizzeria.model.Ingredient;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	@Autowired
	ModelAndView modelAndView;
	@Autowired
	@Qualifier("ingredientDaoRepo")
	IngredientDao ingredientDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listIngredients() {

		List<Ingredient> ingredients = ingredientDao.findAll();
		modelAndView.addObject("ingredients", ingredients);
		modelAndView.setViewName("listeIngredients");
		return modelAndView;

	}

}
