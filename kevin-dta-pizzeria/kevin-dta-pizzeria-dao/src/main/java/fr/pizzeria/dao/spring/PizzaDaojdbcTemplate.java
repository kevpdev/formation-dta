/**
 * 
 */
package fr.pizzeria.dao.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY11
 * @since 5 janv. 2017
 */
@Repository
public class PizzaDaojdbcTemplate implements PizzaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#findAllPizzas()
	 * 
	 * @return
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		String sql = "SELECT * FROM pizza";
		return this.jdbcTemplate.query(sql, (rs, rowNum) -> {

			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setCode(rs.getString("reference"));
			p.setNom(rs.getString("libelle"));
			p.setPrix(rs.getDouble("prix"));
			p.setUrl(rs.getString("url_image"));
			p.setCategPizza(CategoriePizza.valueOf(rs.getString("categ_pizza")));
			return p;
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#addPizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
	@Override
	public boolean addPizza(Pizza p) {

		String sql = "INSERT INTO PIZZA (reference, libelle, prix, categ_pizza, url_image) VALUES(?,?,?,?,?)";
		this.jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(), p.getCategPizza().name(), p.getUrl());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#updatePizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
	@Override
	public boolean updatePizza(Pizza p) {

		//
		// Pizza pizza = getPizzaByCode("PREI");
		// String sql = "UPDATE PIZZA SET reference=?, libelle=?, prix=?,
		// categ_pizza=?, url_image=? WHERE code=?";
		// this.jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(),
		// p.getCategPizza().name(), p.getUrl());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#deletePizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
	@Override
	public boolean deletePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#getPizzaByCode(java.lang.String)
	 * 
	 * @param code
	 * 
	 * @return
	 */
	@Override
	public Pizza getPizzaByCode(String code) {
		String sql = "SELECT * FROM pizza WHERE id= ?";
		return (Pizza) this.jdbcTemplate.query(sql, (rs, rowNum) -> {

			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setCode(rs.getString("reference"));
			p.setNom(rs.getString("libelle"));
			p.setPrix(rs.getDouble("prix"));
			p.setUrl(rs.getString("url_image"));
			p.setCategPizza(CategoriePizza.valueOf(rs.getString("categ_pizza")));
			return p;
		}, code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#getPizzaByPizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 * 
	 * @return
	 */
	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#archivePizza(fr.pizzeria.model.Pizza)
	 * 
	 * @param pizza
	 */
	@Override
	public void archivePizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#findAllArchive()
	 * 
	 * @return
	 */
	@Override
	public List<Pizza> findAllArchive() {
		// TODO Auto-generated method stub
		return null;
	}

}
