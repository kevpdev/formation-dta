package fr.pizzeria.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import fr.pizzeria.model.Pizza;

public class PizzaDaoRest implements PizzaDao {

	public PizzaDaoRest() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pizza> findAllPizzas() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/kevin-pizzeria-web/");
		Invocation.Builder builder = target.path("api").path("rest/pizzas").request();

		List<Pizza> pizzas = builder.get(new GenericType<List<Pizza>>() {
		});
		return pizzas;
	}

	@Override
	public boolean addPizza(Pizza pizza) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/kevin-pizzeria-web/");
		Invocation.Builder builder = target.path("api").path("rest/pizzas").request();
		Response response = builder.post(Entity.json(pizza));
		if (null != response) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/kevin-pizzeria-web/");
		Invocation.Builder builder = target.path("api").path("rest/pizzas/").queryParam("code", pizza.getCode())
				.request();
		Pizza response = builder.put(Entity.json(pizza), Pizza.class);
		if (null != response) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/kevin-pizzeria-web/");
		Invocation.Builder builder = target.path("api").path("rest/pizzas/").queryParam("id", pizza.getId()).request();
		Pizza response = builder.delete(Pizza.class);
		if (null != response) {
			return true;
		}
		return false;
	}

	@Override
	public Pizza getPizzaByCode(String code) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/kevin-pizzeria-web/");
		Invocation.Builder builder = target.path("api").path("rest/pizzas").queryParam("code", code).request();

		Pizza pizza = builder.get(Pizza.class);
		return pizza;
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archivePizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pizza> findAllArchive() {
		// TODO Auto-generated method stub
		return null;
	}

}
