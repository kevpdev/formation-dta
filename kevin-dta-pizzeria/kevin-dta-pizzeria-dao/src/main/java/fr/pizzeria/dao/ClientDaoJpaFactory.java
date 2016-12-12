/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Client;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
public class ClientDaoJpaFactory implements ClientDao {

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public ClientDaoJpaFactory() {
		super();
	}

	@Override
	public List<Client> findAll() {

		return null;
	}

	@Override
	public boolean addClient(Client client) {

		return false;
	}

	@Override
	public boolean updateClient(Client client) {

		return false;
	}

	@Override
	public boolean deleteClient(Client client) {

		return false;
	}

	@Override
	public <T> Client getClientById(T id) {

		return null;
	}

}
