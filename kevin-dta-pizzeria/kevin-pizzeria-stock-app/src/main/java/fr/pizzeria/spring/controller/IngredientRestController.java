/**
 * 
 */
package fr.pizzeria.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.IngredientDao;
import fr.pizzeria.model.Ingredient;

/**
 * @author ETY11
 * @since 9 janv. 2017
 */
@Controller
@RequestMapping("/ingredients")
public class IngredientRestController {

	// @Autowired
	// ModelAndView modelAndView;
	@Autowired
	@Qualifier("ingredientDaoRepo")
	IngredientDao ingredientDao;

	// @RequestMapping(method = RequestMethod.GET, value = "listIngred")
	// public ModelAndView listIngredients() {
	//
	// List<Ingredient> ingredients = ingredientDao.findAll();
	// modelAndView.addObject("ingredients", ingredients);
	// modelAndView.setViewName("listIngred");
	// return modelAndView;
	//
	// }

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> listIngredients() {

		List<Ingredient> ingredients = ingredientDao.findAll();
		return ingredients;

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void addIngredient() {
		Ingredient i = new Ingredient("carotte", 9.99, 10.0);
		ingredientDao.save(i);
	}

}
