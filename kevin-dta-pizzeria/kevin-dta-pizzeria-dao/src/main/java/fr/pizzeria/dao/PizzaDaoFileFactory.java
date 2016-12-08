package fr.pizzeria.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFileFactory implements PizzaDaoFactory {

	private String folderPath = "data/pizza/";
	private Properties prop;

	@Override
	public List<Pizza> findAllPizzas() throws IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Pizza> pizzas = new ArrayList<Pizza>();
		File f = new File(folderPath);
		ArrayList<String> files = new ArrayList<String>(Arrays.asList(f.list()));

		for (String filePath : files) {
			String path = folderPath + filePath;
			InputStream input = new FileInputStream(path);
			List<Field> fields = new ArrayList<>(Arrays.asList(Pizza.class.getDeclaredFields()));
			Pizza pizza = Pizza.class.newInstance();
			// chargement des donn�es du fichier
			getProp().load(input);

			// list des valeurs des champs de la classe pizza
			Set<Object> keys = getProp().keySet();
			// List<Object> listval = new
			// ArrayList<>(Arrays.asList(getProp().values().toArray()));

			for (Object key : keys) {

				Field field = fields.stream().filter(a -> a.getName().equals(key.toString())).findFirst().orElse(null);
				if (field != null) {
					field.setAccessible(true);

					Object valeur = null;

					if (field.getType().isEnum()) {
						valeur = getProp().get(key).toString().toUpperCase();
					} else {
						valeur = getProp().get(key).toString();
					}

					valeur = field.getType()
							.getDeclaredMethod("valueOf",
									(field.getType().isAssignableFrom(String.class) ? Object.class : String.class))
							.invoke(null, valeur);

					field.set(pizza, valeur);

				}

			}

			// System.out.println(pizza);
			pizzas.add(pizza);
		}

		return pizzas;

	}

	@Override
	public boolean addPizza(Pizza pizza)
			throws PizzaException, IllegalArgumentException, IllegalAccessException, IOException {
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
		return true;
	}

	@Override
	public boolean updatePizza(Pizza pizza) throws PizzaException, FileNotFoundException {

		return false;
	}

	@Override
	public boolean deletePizza(Pizza pizza) throws PizzaException, FileNotFoundException {

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

}
