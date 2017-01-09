/**
 * 
 */
package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ETY11
 * @since 9 janv. 2017
 */
@Entity
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String service;
	private Date date;
	private long tempsExecution;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 9 janv. 2017
	 * @author ETY11
	 * @param id
	 * @param service
	 * @param date
	 * @param tempsExecution
	 */
	public Performance(long id, String service, Date date, long tempsExecution) {
		super();
		this.id = id;
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}

	/**
	 * getter id
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * setter id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * getter service
	 * 
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * setter service
	 * 
	 * @param service
	 *            the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * getter date
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * setter date
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * getter tempsExecution
	 * 
	 * @return the tempsExecution
	 */
	public long getTempsExecution() {
		return tempsExecution;
	}

	/**
	 * setter tempsExecution
	 * 
	 * @param tempsExecution
	 *            the tempsExecution to set
	 */
	public void setTempsExecution(long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

}
