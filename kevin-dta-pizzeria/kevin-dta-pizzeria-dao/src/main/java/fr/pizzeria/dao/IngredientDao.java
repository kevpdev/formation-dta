package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Ingredient;

public interface IngredientDao {

	public List<Ingredient> findAll();

	public void save(Ingredient i);

	public void update(Ingredient i);

	public void delete(Ingredient i);

}
