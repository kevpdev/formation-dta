package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Ingredient;

@Repository
public class IngredientDaoRepo implements IngredientDao {
	@Autowired
	private IngredientRepository integredientDao;

	@Override
	public List<Ingredient> findAll() {

		return integredientDao.findAll();
	}

	@Override
	public void save(Ingredient i) {
		integredientDao.save(i);

	}

	@Override
	public void update(Ingredient i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Ingredient i) {
		// TODO Auto-generated method stub

	}

}
