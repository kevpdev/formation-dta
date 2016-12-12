/**
 * 
 */
package fr.pizzeria.ihm_client;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import fr.pizzeria.ihm.ExitMenu;
import fr.pizzeria.ihm.Option;
import fr.pizzeria.tool.IhmUtil;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
public class MenuClient {

	public String titre;
	public IhmUtil ihmUtil;
	public Map<Integer, Option> options = new HashMap<>();
	private Logger LOGGER = Logger.getLogger(AccueilClient.class.getName());

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public MenuClient() {
		super();
	}

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param titre
	 * @param ihmUtil
	 */
	public MenuClient(String titre, IhmUtil ihmUtil) {
		super();
		this.titre = titre;
		this.ihmUtil = ihmUtil;
		this.options.put(0, new CommanderPizza(ihmUtil));
		this.options.put(1, new ListerCommande(ihmUtil));
		this.options.put(2, new ExitMenu());
	}

}
