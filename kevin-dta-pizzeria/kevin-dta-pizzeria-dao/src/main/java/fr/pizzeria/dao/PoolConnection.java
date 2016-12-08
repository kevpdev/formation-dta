package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PoolConnection {

	private Connection con;

	public PoolConnection() {

	}

	public Connection getConnection() {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("mysql.driver");
		try {
			con = DriverManager.getConnection(driver, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
