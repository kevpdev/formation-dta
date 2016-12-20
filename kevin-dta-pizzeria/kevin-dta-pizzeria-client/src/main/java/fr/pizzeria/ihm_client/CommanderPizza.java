/**
 * 
 */
package fr.pizzeria.ihm_client;

import fr.pizzeria.ihm.Option;
import fr.pizzeria.tool.IhmUtil;

/**
 * Classe CommanderPizza
 * 
 * @author ETY11
 * @since 12 déc. 2016
 */
public class CommanderPizza extends Option {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public CommanderPizza(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
		this.setLibelle("1. Commander une pizza");
	}

	@Override
	public void executeOption() {

	}

	@Override
	public void libelleOption() {
		System.out.println(this.getLibelle());
	}

}
