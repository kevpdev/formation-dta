package fr.pizzeria.admin.jax_rs;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.dao.ClientDao;
import fr.pizzeria.model.Client;

@Path("/rest/clients")
public class ClientResource {
	@EJB
	private ClientDao clientdao;

	public ClientResource() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> findAll() {

		return clientdao.findAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean addClient(Client client) {
		return clientdao.addClient(client);
	}

}
