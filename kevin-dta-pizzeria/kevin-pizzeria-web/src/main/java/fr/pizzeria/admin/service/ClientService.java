/**
 * 
 */
package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.EJB;

import fr.pizzeria.dao.ClientDao;
import fr.pizzeria.model.Client;

/**
 * @author ETY11
 * @since 3 janv. 2017
 */
public class ClientService {
	@EJB
	private ClientDao clientDao;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 3 janv. 2017
	 * @author ETY11
	 */
	public ClientService() {
		// TODO Auto-generated constructor stub
	}

	public List<Client> findAll() {

		return clientDao.findAll();

	}

	public boolean addClient(Client client) {
		return clientDao.addClient(client);
	}

	public boolean updateClient(Client client) {
		return clientDao.updateClient(client);
	}

	public boolean deleteClient(Client client) {
		return clientDao.deleteClient(client);
	}

	public Client getClientById(int id) {

		return clientDao.getClientById(id);
	}

	public Client login(String email, String motDePasse) {
		return clientDao.login(email, motDePasse);
	}

}
