/**
 * 
 */
package fr.pizzeria.ihm_client;

import fr.pizzeria.ihm.Option;
import fr.pizzeria.tool.IhmUtil;

/**
 * @author ETY11
 * @since 12 déc. 2016
 */
public class Inscription extends Option {
	private IhmUtil ihmUtil;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public Inscription(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setLibelle("2. S'inscrire");
	}

	@Override
	public void executeOption() {
		// TODO Auto-generated method stub

	}

	@Override
	public void libelleOption() {
		// TODO Auto-generated method stub

	}

}
