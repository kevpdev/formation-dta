package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import fr.pizzeria.excepetion.PizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

public class DeletePizza extends Option {

	public IhmUtil ihmUtil;
	private Logger LOGGER = Logger.getLogger(DeletePizza.class.getName());

	public DeletePizza(IhmUtil ihmUtil) {

		this.setLibelle("4. Suppression d'une pizza");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() throws IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ListPizza listp = new ListPizza(ihmUtil);
		listp.executeOption();

		try {

			System.out.print("Veuillez saisir le code de la pizza �  supprimer: ");
			String codeASupprimer = ihmUtil.getScanner().next();

			Pizza pizzaASup = ihmUtil.getPizzaDao().getPizzaByCode(codeASupprimer);
			if (codeASupprimer != null) {

				System.out.println(ihmUtil.getPizzaDao().deletePizza(pizzaASup) ? "Suppression �ffectu�"
						: "Echec de la suppression");

			} else {
				System.out.println("la pizza � supprimer n'existe pas !");
			}
		} catch (PizzaException e) {
			LOGGER.info(e.getMessage());
		}

	}

	@Override
	public void libelleOption() {
		// TODO Auto-generated method stub
		System.out.println(getLibelle());
	}

}
