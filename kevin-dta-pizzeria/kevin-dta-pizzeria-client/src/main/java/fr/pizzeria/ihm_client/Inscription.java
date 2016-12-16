/**
 * 
 */
package fr.pizzeria.ihm_client;

import fr.pizzeria.ihm.Option;
import fr.pizzeria.model.Client;
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
		this.setLibelle("1. S'inscrire");
	}

	@Override
	public void executeOption() {

		System.out.print("nom : ");
		String nom = ihmUtil.getScanner().nextLine();
		System.out.print("Prenom : ");
		String prenom = ihmUtil.getScanner().nextLine();
		System.out.print("email : ");
		String email = ihmUtil.getScanner().nextLine();
		System.out.print("Mot de passe : ");
		String motDePasse = ihmUtil.getScanner().nextLine();
		System.out.print("adresse : ");
		String adresse = ihmUtil.getScanner().nextLine();
		System.out.print("ville : ");
		String ville = ihmUtil.getScanner().nextLine();
		System.out.print("code postale : ");
		String codePostal = ihmUtil.getScanner().nextLine();
		System.out.print("telephone : ");
		String telephone = ihmUtil.getScanner().nextLine();

		System.out.println(ihmUtil.getClientdao().addClient(
				new Client(nom.toUpperCase(), prenom, email, motDePasse, adresse, ville, codePostal, telephone))
						? "Inscription reussi !!!!" : "echec !!!!");

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());
	}

}
