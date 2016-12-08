package fr.pizzeria.ihm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import fr.pizzeria.excepetion.PizzaException;

public abstract class Option {

	public String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public abstract void executeOption()
			throws PizzaException, FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException,
			InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException;

	public abstract void libelleOption();

}
