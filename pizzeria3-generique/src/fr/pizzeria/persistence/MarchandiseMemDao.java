package fr.pizzeria.persistence;

import fr.pizzeria.model.Marchandise;
import fr.pizzeria.model.MarchandiseType;

public class MarchandiseMemDao implements IMarchandiseDao {
	
	private MarchandiseType[] marchandiseTypes;
	private Marchandise[] marchandises;
	
	public MarchandiseMemDao() {
	}
		
	public MarchandiseMemDao(MarchandiseType[] marchandiseTypes, Marchandise[] tableauInitialDeMarchandise) {
		this.marchandiseTypes = marchandiseTypes;
		this.marchandises = tableauInitialDeMarchandise;
	}
	
	
	public void saveNewMarchandiseType(MarchandiseType mType) {
		MarchandiseType[] mTypes2 = new MarchandiseType[marchandiseTypes.length + 1];
		for(int i = 0, limite = marchandiseTypes.length; i < limite; i++) {
			mTypes2[i] = marchandiseTypes[i];
		}
		mTypes2[marchandiseTypes.length] = mType;
		marchandiseTypes = mTypes2;
	}
	
	
	public MarchandiseType[] findMarchandiseTypesByType(String type) {
		int nbMTypeValide = 0;
		for(MarchandiseType mType : marchandiseTypes) {
			if(mType.type.equals(type)) {
				nbMTypeValide++;
			}
		}
		MarchandiseType[] mTypes = new MarchandiseType[nbMTypeValide];
		for(int i = 0, j = 0, lim = marchandiseTypes.length; i < lim; i++) {
			if(marchandiseTypes[i].type.equals(type)) {
				mTypes[j] = marchandiseTypes[i];
				j++;
			}
		}
		return mTypes;
	}
	
	@Override
	public Marchandise[] findAllMarchandises() {
		return marchandises;
	}
	
	public MarchandiseType[] findAllMarchandiseTypes() {
		return marchandiseTypes;
	}

	@Override
	public void saveNewMarchandise(Marchandise Marchandise) {
		Marchandise[] Marchandises2 = new Marchandise[marchandises.length + 1];
		for(int i = 0, limite = marchandises.length; i < limite; i++) {
			Marchandises2[i] = marchandises[i];
		}
		Marchandises2[marchandises.length] = Marchandise;
		marchandises = Marchandises2;
	}

	@Override
	public void updateMarchandise(String codeMarchandise, Marchandise Marchandise) {
		if(MarchandiseExists(codeMarchandise)) {
			for(int i = 0, limite = marchandises.length; i < limite; i++) {
				if(marchandises[i].code.equals(codeMarchandise)) {
					marchandises[i] = Marchandise;
					break;
				}
			}
		}
	}

	@Override
	public void deleteMarchandise(String codeMarchandise) {
		if(MarchandiseExists(codeMarchandise)) {
			Marchandise[] Marchandises2 = new Marchandise[marchandises.length - 1];
			for(int i = 0, j = 0, limite = marchandises.length; i < limite; i++) {
				if(!marchandises[i].code.equals(codeMarchandise)) {
					Marchandises2[j] = marchandises[i];
					j++;
				}
			}
			marchandises = Marchandises2;
		}
	}

	@Override
	public Marchandise findMarchandiseByCode(String codeMarchandise) {
		for(int i = 0, limite = marchandises.length; i < limite; i++) {
			if(marchandises[i].code.equals(codeMarchandise)) {
				return marchandises[i];
			}
		}
		return null;
	}

	public MarchandiseType findMarchandiseTypeByCode(String codeMarchandise) {
		for(int i = 0, limite = marchandises.length; i < limite; i++) {
			if(marchandises[i].code.equals(codeMarchandise)) {
				for(MarchandiseType mType : marchandiseTypes) {
					if(mType.type.equals(marchandises[i].type)) {
						return mType;
					}
				}
			}
		}
		return null;
	}
	
	public boolean MarchandiseTypeExists(MarchandiseType mType) {
		for(int i = 0, limite = marchandiseTypes.length; i < limite; i++) {
			if(marchandiseTypes[i].equals(mType)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean MarchandiseTypeExists(String type) {
		for(int i = 0, limite = marchandiseTypes.length; i < limite; i++) {
			if(marchandiseTypes[i].type.equals(type)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean MarchandiseExists(String codeMarchandise) {
		for(int i = 0, limite = marchandises.length; i < limite; i++) {
			if(marchandises[i].code.equals(codeMarchandise)) {
				return true;
			}
		}
		return false;
	}

}
