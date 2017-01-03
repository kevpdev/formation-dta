package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Client;

public interface ClientDao {

	List<Client> findAll();

	boolean addClient(Client client);

	boolean updateClient(Client client);

	boolean deleteClient(Client client);

	Client getClientById(int id);

	Client login(String email, String motDePasse);
}
