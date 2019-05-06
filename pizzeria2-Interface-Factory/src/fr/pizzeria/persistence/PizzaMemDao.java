package fr.pizzeria.persistence;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	private Pizza[] pizzas;
	
	public PizzaMemDao(Pizza[] tableauInitialDePizza) {
		this.pizzas = tableauInitialDePizza;
	}
	
	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		Pizza[] pizzas2 = new Pizza[pizzas.length + 1];
		for(int i = 0, limite = pizzas.length; i < limite; i++) {
			pizzas2[i] = pizzas[i];
		}
		pizzas2[pizzas.length] = pizza;
		pizzas = pizzas2;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		if(pizzaExists(codePizza)) {
			for(int i = 0, limite = pizzas.length; i < limite; i++) {
				if(pizzas[i].code.equals(codePizza)) {
					pizzas[i] = pizza;
					break;
				}
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		if(pizzaExists(codePizza)) {
			Pizza[] pizzas2 = new Pizza[pizzas.length - 1];
			for(int i = 0, j = 0, limite = pizzas.length; i < limite; i++) {
				if(!pizzas[i].code.equals(codePizza)) {
					pizzas2[j] = pizzas[i];
					j++;
				}
			}
			pizzas = pizzas2;
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for(int i = 0, limite = pizzas.length; i < limite; i++) {
			if(pizzas[i].code.equals(codePizza)) {
				return pizzas[i];
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for(int i = 0, limite = pizzas.length; i < limite; i++) {
			if(pizzas[i].code.equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

}
