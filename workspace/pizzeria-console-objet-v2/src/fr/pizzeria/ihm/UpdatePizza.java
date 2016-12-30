package fr.pizzeria.ihm;


import fr.pizzeria.excpetion.PizzaException;
import fr.pizzeria.excpetion.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tool.IhmUtil;

public class UpdatePizza extends Option {

	public IhmUtil ihmUtil;

	public  UpdatePizza(IhmUtil ihmUtil) {

		this.setLibelle("3. Mise � jour d'une pizza");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executeOption() throws PizzaException{
		

			ListPizza listp = new ListPizza(ihmUtil);
			listp.executeOption();

			System.out.print("Veuillez saisir le code de la pizza � modifier: ");
			String codeAmodifier = ihmUtil.getScanner().next(); 

			Pizza pizzaAModifier = ihmUtil.getPizzaDao().getPizzaByCode(codeAmodifier);
			if (!(pizzaAModifier == null)) {

				System.out.print("Veuillez saisir le nouveau code: ");
				String code = ihmUtil.getScanner().next();

				System.out.print("Veuillez saisir le nouveau nom: ");
				String nom = ihmUtil.getScanner().next(); 

				System.out.print("Veuillez saisir le nouveau prix: ");
				double prix = ihmUtil.getScanner().nextDouble(); 

				Pizza pizza = new Pizza(pizzaAModifier.getId(), code, nom, prix);

				if(ihmUtil.getPizzaDao().updatePizza(pizza)){
					System.out.println("Mise � jour �ffectu� !");
				}else{
					System.out.println("Echec de la mise � jour !");
				}


			}

		
	}

	@Override
	public void libelleOption() {
		// TODO Auto-generated method stub
		System.out.println(getLibelle());
	}

}
