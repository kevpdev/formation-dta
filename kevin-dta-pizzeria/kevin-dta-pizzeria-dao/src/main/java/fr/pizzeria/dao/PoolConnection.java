package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PoolConnection {

	private Connection con;

	public PoolConnection() {

	}

	public Connection getConnection() throws SQLException {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("mysql.driver");

		con = DriverManager.getConnection(driver, "root", "");

		return con;
	}

}
