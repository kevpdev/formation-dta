package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.PizzaDaoJpaFactory;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzeriaServletWebApi
 */
public class PizzeriaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final PizzaDaoJpaFactory pizzaDao = new PizzaDaoJpaFactory();

	/**
	 * Default constructor.
	 */
	public PizzeriaServletWebApi() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		response.getWriter().append(pizzas.toString());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("categ"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		pizzaDao.addPizza(pizza);
		resp.setStatus(201);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("categ"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		pizzaDao.updatePizza(pizza);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
		String codePizza = req.getParameter("code");
		Pizza pizza = new Pizza();
		pizza.setCode(codePizza);
		pizzaDao.deletePizza(pizza);
	}

}
