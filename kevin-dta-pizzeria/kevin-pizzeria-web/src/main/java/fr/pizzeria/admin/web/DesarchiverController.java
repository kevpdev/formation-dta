package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.service.PizzaService;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class DesarchiverController
 */
@WebServlet("/pizzas/desarchiver")
public class DesarchiverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private PizzaService servicePizza;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DesarchiverController() {
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
		Pizza pizza = servicePizza.getPizzaByCode(code);
		Logger.getLogger(EditerPizzaController.class.getName()).info("pizza : " + pizza);

		if (pizza != null) {
			pizza.setArchive(true);
			servicePizza.archivePizza(pizza);

			response.sendRedirect(request.getContextPath() + "/pizzas/corbeille");
		} else {
			response.sendRedirect("/pizzas/error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
