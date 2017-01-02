/**
 * 
 */
package fr.pizzeria.admin.jax_rs;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY11
 * @since 2 janv. 2017
 */
@Path("rest/pizzas")
public class PizzaResource {

	@EJB
	private PizzaDao pizzaDao;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 2 janv. 2017
	 * @author ETY11
	 */
	public PizzaResource() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> findAllNoArchive() {

		return pizzaDao.findAllPizzas();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean addPizza(Pizza pizza) {
		return pizzaDao.addPizza(pizza);
	}

	@PUT
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updatePizza(@PathParam("code") String code, Pizza pizza) {

		return pizzaDao.updatePizza(pizza);
	}

	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza getPizzaByCode(@PathParam("code") String code) {
		return pizzaDao.getPizzaByCode(code);
	}

	// @PUT
	// @Path("/{id}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public void archivePizza(@PathParam("id") Integer id) {
	// Pizza pizza = new Pizza();
	// pizza.setId(id);
	// pizzaDao.archivePizza(pizza);
	// }

}
