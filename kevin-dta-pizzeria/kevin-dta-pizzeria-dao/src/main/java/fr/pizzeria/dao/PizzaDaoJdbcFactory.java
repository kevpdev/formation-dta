package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe PizzaDaoJdbcFactory
 * 
 * @author ETY11
 *
 */
public class PizzaDaoJdbcFactory implements PizzaDao {

	private DataSourceConfig datasource;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public PizzaDaoJdbcFactory() {
		super();
	}

	/**
	 * Getter
	 * 
	 * @return
	 */
	public DataSourceConfig getDatasource() {
		if (datasource == null) {
			datasource = new DataSourceConfig();
		}
		return datasource;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<>();

		return execute((con, st) -> {
			try {
				ResultSet resultat = st.executeQuery("SELECT * FROM pizza");

				while (resultat.next()) {
					pizzas.add(new Pizza(resultat.getInt("id"), resultat.getString("reference"),
							resultat.getString("libelle"), resultat.getDouble("prix"),
							CategoriePizza.valueOf(resultat.getString("categ_pizza"))));
				}

			} catch (SQLException e) {
				throw new PizzaException(e);
			}

			return pizzas;

		});

	}

	@Override
	public boolean addPizza(Pizza pizza) {

		return executePrep(con -> {
			try {

				java.sql.PreparedStatement update = con.prepareStatement(
						"INSERT INTO pizza (libelle, reference, prix, categ_pizza) value(?, ?, ?, ?)");
				update.setString(1, pizza.getNom());
				update.setString(2, pizza.getCode());
				update.setDouble(3, pizza.getPrix());
				update.setString(4, pizza.getCategPizza().toString());
				update.executeUpdate();

				return true;

			} catch (SQLException e) {
				throw new PizzaException(e);
			}

		});
	}

	@Override
	public boolean updatePizza(Pizza pizza) {

		return executePrep(con -> {
			try {

				java.sql.PreparedStatement update = con.prepareStatement(
						"UPDATE pizza SET libelle = ?, reference = ?, prix =  ?, categ_pizza = ? WHERE id = ?");
				update.setString(1, pizza.getNom());
				update.setString(2, pizza.getCode());
				update.setDouble(3, pizza.getPrix());
				update.setString(4, pizza.getCategPizza().toString());
				update.setInt(5, pizza.getId());
				update.executeUpdate();

				return true;

			} catch (SQLException e) {
				throw new PizzaException(e);
			}

		});
	}

	@Override
	public boolean deletePizza(Pizza pizza) {
		return executePrep(con -> {
			try {

				java.sql.PreparedStatement update = con.prepareStatement("DELETE FROM pizza WHERE id = ?");

				update.setInt(1, pizza.getId());
				update.executeUpdate();
				return true;

			} catch (SQLException e) {
				throw new PizzaException(e);
			}

		});

	}

	@Override
	public Pizza getPizzaByCode(String code) {
		Pizza pizza = new Pizza();
		return executePrep(con -> {
			try {

				java.sql.PreparedStatement select = con.prepareStatement("SELECT * FROM pizza WHERE reference = ?");
				select.setString(1, code.toString());
				ResultSet resultat = select.executeQuery();
				while (resultat.next()) {

					pizza.setId(resultat.getInt("id"));
					pizza.setCode(resultat.getString("reference"));
					pizza.setNom(resultat.getString("libelle"));
					pizza.setPrix(resultat.getDouble("prix"));
					pizza.setCategPizza(CategoriePizza.valueOf(resultat.getString("categ_pizza")));

					break;

				}
				resultat.close();
			} catch (SQLException e) {
				throw new PizzaException(e);
			}
			return pizza;

		});
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {
		return executePrep(con -> {
			try {

				java.sql.PreparedStatement select = con.prepareStatement("SELECT * FROM pizza WHERE reference = ?");
				select.setString(1, pizza.getCode());
				ResultSet resultat = select.executeQuery();
				while (resultat.next()) {

					pizza.setId(resultat.getInt("id"));
					pizza.setCode(resultat.getString("reference"));
					pizza.setNom(resultat.getString("libelle"));
					pizza.setPrix(resultat.getDouble("prix"));
					pizza.setCategPizza(CategoriePizza.valueOf(resultat.getString("categ_pizza")));

					break;

				}
				resultat.close();
			} catch (SQLException e) {
				throw new PizzaException(e);
			}
			return pizza;

		});
	}

	interface IRunSql<T> {
		T exec(Connection con, Statement st);
	}

	interface IRunSqlPrep<T> {
		T exec(Connection conn) throws SQLException;
	}

	/*
	 * 
	 */
	public <T> T execute(IRunSql<T> run) {
		try (Connection con = getDatasource().getConnection(); Statement stat = con.createStatement()) {

			return run.exec(con, stat);
		} catch (SQLException e) {
			throw new PizzaException(e);
		}

	}

	/**
	 * 
	 * @param run
	 * @return
	 */
	public <T> T executePrep(IRunSqlPrep<T> run) {
		try (Connection con = getDatasource().getConnection()) {

			return run.exec(con);
		} catch (SQLException e) {
			throw new PizzaException(e);
		}

	}

	/**
	 * 
	 */
	@Override
	public boolean importPizza() {
		List<Pizza> pizzasFile = new PizzaDaoFileFactory().findAllPizzas();

		List<List<Pizza>> superListPizzas = ListUtils.partition(pizzasFile, 3);

		return executePrep(con -> {
			con.setAutoCommit(false);
			java.sql.PreparedStatement update = con
					.prepareStatement("INSERT INTO pizza (libelle, reference, prix, categ_pizza) value(?, ?, ?, ?)");
			for (List<Pizza> pizzas : superListPizzas) {
				try {
					for (Pizza pizza : pizzas) {

						update.setString(1, pizza.getNom());
						update.setString(2, pizza.getCode());
						update.setDouble(3, pizza.getPrix());
						update.setString(4, pizza.getCategPizza().toString());
						update.executeUpdate();
					}
					con.commit();
				} catch (SQLException e) {
					Logger.getLogger(PizzaDaoJdbcFactory.class.getName()).info(e.getMessage());
					try {
						con.rollback();
					} catch (SQLException e1) {

						throw new PizzaException(e1);
					}
				}
			}
			return true;
		});
	}

	@Override
	public void archivePizza(Pizza pizza) {

	}

	@Override
	public List<Pizza> findAllArchive() {
		return null;
	}

}
