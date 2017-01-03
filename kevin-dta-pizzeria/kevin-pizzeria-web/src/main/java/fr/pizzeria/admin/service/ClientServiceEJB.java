package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.ClientDao;
import fr.pizzeria.model.Client;

@Stateless
public class ClientServiceEJB implements ClientDao {

	@PersistenceContext(unitName = "pizza-db")
	private EntityManager em;

	public ClientServiceEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = em.createNamedQuery("client.findAll", Client.class);
		List<Client> clients = query.getResultList();
		return clients;

	}

	@Override
	public boolean addClient(Client client) {
		client.setId(0);
		em.persist(client);

		return true;
	}

	@Override
	public boolean updateClient(Client client) {
		Client clientUpdate = em.find(Client.class, client.getId());

		if (clientUpdate != null) {
			clientUpdate.setNom(client.getNom());
			clientUpdate.setPrenom(client.getPrenom());
			clientUpdate.setEmail(client.getEmail());
			clientUpdate.setMotDePasse(client.getMotDePasse());
			clientUpdate.setAdresse(client.getAdresse());
			clientUpdate.setVille(client.getVille());
			clientUpdate.setCodePostal(client.getCodePostal());
			clientUpdate.setTelephone(client.getTelephone());
			em.merge(clientUpdate);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteClient(Client client) {
		Client clientDelete = em.find(Client.class, client.getId());

		if (clientDelete != null) {
			em.remove(clientDelete);
			return true;
		}

		return false;
	}

	@Override
	public Client getClientById(int id) {

		Client client = em.find(Client.class, id);

		return client;
	}

	@Override
	public Client login(String email, String motDePasse) {
		TypedQuery<Client> query = em.createNamedQuery("client.login", Client.class);
		query.setParameter("email", email);
		query.setParameter("motDePasse", motDePasse);
		Client client = query.getResultList().get(0);
		return client;
	}

}
