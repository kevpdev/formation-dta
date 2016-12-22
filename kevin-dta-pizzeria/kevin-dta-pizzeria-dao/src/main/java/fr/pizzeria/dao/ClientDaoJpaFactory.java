/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
public class ClientDaoJpaFactory implements ClientDao {

	private EntityManagerFactory emf;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public ClientDaoJpaFactory() {
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		setEmf(Persistence.createEntityManagerFactory("pizza-db"));
	}

	@Override
	public List<Client> findAll() {

		return null;
	}

	@Override
	public boolean addClient(Client client) {

		EntityManager em = getEmf().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(client);
		et.commit();
		em.close();

		return true;
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

	@Override
	public Client login(String email, String password) {

		EntityManager em = getEmf().createEntityManager();
		TypedQuery<Client> query = em.createNamedQuery("client.login", Client.class);
		query.setParameter("email", email);
		query.setParameter("motDePasse", password);
		Client client = query.getResultList().get(0);

		return client;
	}

	/**
	 * getter emf
	 * 
	 * @return the emf
	 */
	public EntityManagerFactory getEmf() {
		return emf;
	}

	/**
	 * setter emf
	 * 
	 * @param emf
	 *            the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
