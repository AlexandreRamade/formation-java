package fr.pizzeria.persistence;

import fr.pizzeria.model.Marchandise;

public interface IMarchandiseDao {
	Marchandise[] findAllMarchandises();
	void saveNewMarchandise(Marchandise Marchandise);
	void updateMarchandise(String codeMarchandise, Marchandise Marchandise);
	void deleteMarchandise(String codeMarchandise);
	Marchandise findMarchandiseByCode(String codeMarchandise);
	boolean MarchandiseExists(String codeMarchandise);
}
