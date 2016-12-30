package fr.pizzeria.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

/**
 * Classe PizzaDaoJdbcFactory
 * 
 * @author ETY11
 *
 */
public class PizzaDaoFileFactory implements PizzaDao {

	private String folderPath = "data/pizza/";
	private Properties prop;

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		File f = new File(folderPath);
		ArrayList<String> files = new ArrayList<>(Arrays.asList(f.list()));

		for (String filePath : files) {
			String path = folderPath + filePath;
			Pizza pizza;
			try {
				InputStream input = new FileInputStream(path);
				List<Field> fields = new ArrayList<>(Arrays.asList(Pizza.class.getDeclaredFields()));

				pizza = Pizza.class.newInstance();
				getProp().load(input);

				// list des clés des champs de la classe pizza
				Set<Object> keys = getProp().keySet();

				for (Object key : keys) {

					Field field = fields.stream().filter(a -> a.getName().equals(key.toString())).findFirst()
							.orElse(null);
					if (field != null) {
						field.setAccessible(true);

						Object value = field.getType()
								.getDeclaredMethod("valueOf",
										field.getType().isAssignableFrom(String.class) ? Object.class : String.class)
								.invoke(null, field.getType().isEnum() ? getProp().get(key).toString().toUpperCase()
										: getProp().get(key).toString());

						field.set(pizza, value);
					}
				}

				pizzas.add(pizza);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException | IOException e1) {
				Logger.getLogger(PizzaDaoJdbcFactory.class.getName()).severe(e1.getMessage());
				throw new PizzaException(e1);
			}

		}
		return pizzas;

	}

	@Override
	public boolean addPizza(Pizza pizza) {

		try {
			String filename = folderPath + pizza.getCode() + ".properties";
			OutputStream output = new FileOutputStream(filename);

			Field[] champs = Pizza.class.getDeclaredFields();
			for (Field field : champs) {
				if (field != null && field.getName() != "nbPizzas") {
					field.setAccessible(true);
					getProp().setProperty(field.getName(), field.get(pizza).toString());

				}
			}
			prop.store(output, null);
			output.close();
		} catch (IOException | IllegalArgumentException | IllegalAccessException e) {
			Logger.getLogger(PizzaDaoJdbcFactory.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}
		return true;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {

		return false;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {

		return false;
	}

	@Override
	public Pizza getPizzaByCode(Object code) {

		return null;
	}

	@Override
	public Pizza getPizzaByPizza(Pizza pizza) {

		return null;
	}

	public Properties getProp() {
		if (prop == null)
			prop = new Properties();

		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public void archivePizza(Pizza pizza) {

	}

	@Override
	public List<Pizza> findAllArchive() {
		return null;
	}

}
