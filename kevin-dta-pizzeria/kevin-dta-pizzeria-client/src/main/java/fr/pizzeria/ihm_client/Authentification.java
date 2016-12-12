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
public class Authentification extends Option {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 */
	public Authentification(IhmUtil ihmUtil) {
		this.setIhmUtil(ihmUtil);
		this.setLibelle("2. Se connecter");
	}

	@Override
	public void executeOption() {
		// TODO Auto-generated method stub

	}

	@Override
	public void libelleOption() {
		// TODO Auto-generated method stub

	}

	/**
	 * getter ihmUtil
	 * 
	 * @return the ihmUtil
	 */
	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	/**
	 * setter ihmUtil
	 * 
	 * @param ihmUtil
	 *            the ihmUtil to set
	 */
	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
