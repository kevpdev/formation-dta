package fr.pizzeria.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.model.TypeTriPizza;
import fr.pizzeria.tool.IhmUtil;

/**
 * Classe ImportPizza
 * 
 * @author ETY11
 *
 */
@Controller
public class ImportPizza extends Option {
	@Autowired
	public IhmUtil ihmUtil;
	public TypeTriPizza ttp;

	/**
	 * 
	 * Constructeur de la classe
	 * 
	 * @date 12 déc. 2016
	 * @author ETY11
	 * @param ihmUtil
	 */
	public ImportPizza() {
		this.setLibelle("7. Importer les données (base de données)");
	}

	@Override
	public void executeOption() {

		System.out.println("Voulez-vous importer les données (O/N) ?");

		String rep = ihmUtil.getScanner().next();
		System.out.println("O".equals(rep) ? ihmUtil.getPizzaDao().importPizza() : "pas d'importation");

	}

	@Override
	public void libelleOption() {
		System.out.println(getLibelle());

	}

}
