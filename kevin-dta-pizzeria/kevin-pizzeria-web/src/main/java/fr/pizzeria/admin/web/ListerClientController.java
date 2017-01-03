package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.pizzeria.admin.service.ClientService;
import fr.pizzeria.model.Client;

/**
 * Servlet implementation class ListerClientController
 */
@WebServlet("/clients")
public class ListerClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ClientService clientService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerClientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Client> clients = clientService.findAll();
		ObjectMapper mapper = new ObjectMapper();
		// mapper.writeValue(resultFile, value);
		response.getWriter().println(clients);
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
