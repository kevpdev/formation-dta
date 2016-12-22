package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.service.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class AjouterPizzaController
 */
@WebServlet("/pizzas/new")
public class AjouterPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private PizzaService servicePizza;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterPizzaController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ajouterPizza.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String categ = request.getParameter("categ_pizza");
		String url = request.getParameter("url_image");

		Pizza pizza = new Pizza();
		pizza.setCode(code);
		pizza.setNom(nom);
		pizza.setPrix(Double.parseDouble(prix));
		pizza.setCategPizza(CategoriePizza.valueOf(categ));
		pizza.setUrl(url);
		servicePizza.addPizza(pizza);

		response.sendRedirect(request.getContextPath() + "/pizzas/list");

	}

}
