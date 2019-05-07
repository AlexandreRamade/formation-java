package fr.pizzeria.persistence;

import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	private List<Pizza> pizzas;
	
	public PizzaMemDao(List<Pizza> listInitialDePizza) {
		this.pizzas = listInitialDePizza;
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzas.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		if(pizzaExists(codePizza)) {
			for(int i = 0, lim = pizzas.size(); i < lim; i++) {
				if(pizzas.get(i).getCode().equals(codePizza)) {
					pizzas.remove(i);
					pizzas.add(i, pizza);
				}
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		if(pizzaExists(codePizza)) {
			for(int i = 0, lim = pizzas.size(); i < lim; i++) {
				if (pizzas.get(i).getCode().equals(codePizza)) {
					pizzas.remove(i);
				}
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for(Pizza pizz : pizzas) {
			if(pizz.getCode().equals(codePizza)) {
				return pizz;
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for(Pizza pizz : pizzas) {
			if(pizz.getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

}
