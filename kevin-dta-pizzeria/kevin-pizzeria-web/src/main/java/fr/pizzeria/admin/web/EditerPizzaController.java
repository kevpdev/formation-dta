package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.PizzaDaoJpaFactory;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final PizzaDaoJpaFactory pizzaDao = new PizzaDaoJpaFactory();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerPizzaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		Pizza pizza = pizzaDao.getPizzaByCode(code);
		Logger.getLogger(EditerPizzaController.class.getName()).info("pizza : " + pizza);

		if (pizza != null) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/editerPizza.jsp");
			request.setAttribute("pizza", pizza);
			dispatcher.forward(request, response);
		}
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
		Pizza pizza = pizzaDao.getPizzaByCode(code);
		Logger.getLogger(EditerPizzaController.class.getName()).info("pizza : " + pizza);

		if (pizza != null) {

			pizza.setCode(code);
			pizza.setNom(nom);
			pizza.setPrix(Double.parseDouble(prix));
			pizza.setCategPizza(CategoriePizza.valueOf(categ));
			pizza.setUrl(url);
			pizzaDao.updatePizza(pizza);

			response.sendRedirect(request.getContextPath() + "/pizzas/list");
		} else {
			response.sendRedirect("/pizzas/error");
		}

	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
