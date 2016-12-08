package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.CategoriePizza;
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
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<>();

		try (Connection con = getpc().getConnection()) {

			java.sql.Statement statement = con.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM pizza");
			while (resultat.next()) {
				pizzas.add(
						new Pizza(resultat.getInt("id"), resultat.getString("reference"), resultat.getString("libelle"),
								resultat.getDouble("prix"), CategoriePizza.valueOf(resultat.getString("categ_pizza"))));

			}

		} catch (SQLException e) {
			throw new PizzaException(e);
		}
		return pizzas;
	}

	@Override
	public boolean addPizza(Pizza pizza) {
		try (Connection con = getpc().getConnection()) {
			java.sql.PreparedStatement update = con
					.prepareStatement("INSERT INTO pizza (libelle, reference, prix, categ_pizza) value(?, ?, ?)");
			update.setString(1, pizza.getNom());
			update.setString(2, pizza.getCode());
			update.setDouble(3, pizza.getPrix());
			update.setString(4, pizza.getCategPizza().toString());
			update.executeUpdate();

		} catch (SQLException e) {
			throw new PizzaException(e);
		}

		return true;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {
		try (Connection con = getpc().getConnection()) {
			java.sql.PreparedStatement update = con.prepareStatement(
					"UPDATE pizza SET libelle = ?, reference = ?, prix =  ?, categ_pizza = ? WHERE id = ?");
			update.setString(1, pizza.getNom());
			update.setString(2, pizza.getCode());
			update.setDouble(3, pizza.getPrix());
			update.setString(4, pizza.getCategPizza().toString());
			update.setInt(5, pizza.getId());
			update.executeUpdate();

		} catch (SQLException e) {
			throw new PizzaException(e);
		}
		return true;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {
		try (Connection con = getpc().getConnection()) {
			java.sql.PreparedStatement update = con.prepareStatement("DELETE FROM pizza WHERE id = ?");
			update.setInt(1, pizza.getId());
			update.executeUpdate();

		} catch (SQLException e) {
			throw new PizzaException(e);
		}
		return true;

	}

	@Override
	public Pizza getPizzaByCode(Object code) {
		try (Connection con = getpc().getConnection()) {
			java.sql.PreparedStatement select = con.prepareStatement("SELECT * FROM pizza WHERE reference = ?");
			select.setString(1, code.toString());
			ResultSet resultat = select.executeQuery();
			while (resultat.next()) {
				return new Pizza(resultat.getInt("id"), resultat.getString("reference"), resultat.getString("libelle"),
						resultat.getDouble("prix"));

			}
		} catch (SQLException e) {
			throw new PizzaException(e);
		}
		return null;
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {
		try (Connection con = getpc().getConnection()) {
			java.sql.PreparedStatement select = con.prepareStatement("SELECT * FROM pizza WHERE reference = ?");
			select.setString(1, pizza.getCode());
			ResultSet resultat = select.executeQuery();
			while (resultat.next()) {
				return new Pizza(resultat.getInt("id"), resultat.getString("reference"), resultat.getString("libelle"),
						resultat.getDouble("prix"));

			}
		} catch (SQLException e) {
			throw new PizzaException(e);
		}
		return null;
	}

}
