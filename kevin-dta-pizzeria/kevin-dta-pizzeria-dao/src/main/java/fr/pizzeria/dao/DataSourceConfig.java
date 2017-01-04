package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe PoolConnection
 * 
 * @author ETY11
 *
 */
public class DataSourceConfig {

	private Connection con;
	private String url;
	private String user;
	private String root;
	private String password;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public DataSourceConfig() {
		super();
	}

	/**
	 * Constructeur de la classe
	 * 
	 * @date 4 janv. 2017
	 * @author ETY11
	 * @param url
	 * @param user
	 * @param root
	 * @param password
	 */
	public DataSourceConfig(String url, String user, String root, String password) {
		super();
		this.url = url;
		this.user = user;
		this.root = root;
		this.password = password;
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

	/**
	 * getter url
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * setter url
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * getter user
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * setter user
	 * 
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * getter root
	 * 
	 * @return the root
	 */
	public String getRoot() {
		return root;
	}

	/**
	 * setter root
	 * 
	 * @param root
	 *            the root to set
	 */
	public void setRoot(String root) {
		this.root = root;
	}

	/**
	 * getter password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter password
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
