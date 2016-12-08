package fr.pizzeria.ihm;

import fr.pizzeria.model.TypeTriPizza;
import fr.pizzeria.tool.IhmUtil;

public class ImportPizza extends Option {

	public IhmUtil ihmUtil;
	public TypeTriPizza ttp;

	public ImportPizza(IhmUtil ihmUtil) {
		this.setLibelle("7. Importer les données (base de données)");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() {

	}

	@Override
	public void libelleOption() {

	}

}
