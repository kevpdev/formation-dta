package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PoolConnection {

	private Connection con;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public PoolConnection() {
		super();
	}

	/**
	 * 
	 * @return Connection
	 * @throws SQLException
	 *             Connection
	 */
	public Connection getConnection() throws SQLException {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String url = bundle.getString("jdbc.mysql.url");

		con = DriverManager.getConnection(url, bundle.getString("jdbc.mysql.user"), bundle.getString("jdbc.mysql.pwd"));

		return con;
	}

}
