package fr.pizzeria.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbcFactory implements PizzaDaoFactory {

	private PoolConnection pc;

	public PizzaDaoJdbcFactory() {

	}

	public PoolConnection getpc() {
		if (pc == null) {
			pc = new PoolConnection();
		}
		return pc;
	}

	@Override
	public List<Pizza> findAllPizzas()
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		List<Pizza> pizzas = new ArrayList<>();
		java.sql.Statement statement = getpc().getConnection().createStatement();
		ResultSet resultat = statement.executeQuery("SELECT * FROM pizza");
		while (resultat.next()) {
			pizzas.add(new Pizza(resultat.getInt("id"), resultat.getString("reference"), resultat.getString("libelle"),
					resultat.getDouble("prix")));

		}

		return pizzas;
	}

	@Override
	public boolean addPizza(Pizza pizza) throws PizzaException, FileNotFoundException, IllegalArgumentException,
			IllegalAccessException, IOException, SQLException {
		java.sql.PreparedStatement update = getpc().getConnection()
				.prepareStatement("INSERT INTO pizza (libelle, reference, prix) value(?, ?, ?)");
		update.setString(1, pizza.getNom());
		update.setString(2, pizza.getCode());
		update.setDouble(3, pizza.getPrix());
		update.executeUpdate();

		return true;
	}

	@Override
	public boolean updatePizza(Pizza pizza) throws PizzaException, FileNotFoundException, SQLException {
		java.sql.PreparedStatement update = getpc().getConnection()
				.prepareStatement("UPDATE pizza SET libelle = ?, reference = ?, prix =  ? WHERE id = ?");
		update.setString(1, pizza.getNom());
		update.setString(2, pizza.getCode());
		update.setDouble(3, pizza.getPrix());
		update.setInt(4, pizza.getId());
		update.executeUpdate();

		return true;
	}

	@Override
	public boolean deletePizza(Pizza pizza) throws PizzaException, FileNotFoundException, SQLException {
		java.sql.PreparedStatement update = getpc().getConnection().prepareStatement("DELETE FROM pizza WHERE id = ?");
		update.setInt(1, pizza.getId());
		update.executeUpdate();

		return true;

	}

	@Override
	public Pizza getPizzaByCode(Object code) throws SQLException {
		java.sql.PreparedStatement select = getpc().getConnection()
				.prepareStatement("SELECT * FROM pizza WHERE reference = ?");
		select.setString(1, code.toString());
		ResultSet resultat = select.executeQuery();
		while (resultat.next()) {
			return new Pizza(resultat.getInt("id"), resultat.getString("reference"), resultat.getString("libelle"),
					resultat.getDouble("prix"));

		}
		return null;
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) throws SQLException {
		java.sql.PreparedStatement select = getpc().getConnection()
				.prepareStatement("SELECT * FROM pizza WHERE reference = ?");
		select.setString(1, pizza.getCode());
		ResultSet resultat = select.executeQuery();
		while (resultat.next()) {
			return new Pizza(resultat.getInt("id"), resultat.getString("reference"), resultat.getString("libelle"),
					resultat.getDouble("prix"));

		}
		return null;
	}

}
