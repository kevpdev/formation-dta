package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.service.PizzaService;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaArchiveController
 */
@WebServlet("/pizzas/corbeille")
public class ListerPizzaArchiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private PizzaService servicePizza;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzaArchiveController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pizza> pizzas = servicePizza.findAllArchive();
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/listerArchive.jsp");
		request.setAttribute("pizzas", pizzas);
		dispatcher.forward(request, response);

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
