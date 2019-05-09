package fr.fcc.utils;

import java.lang.reflect.Field;

public class ClassToJson {
	static public String toJson(Object o) {
		
		Class<? extends Object> maClass = o.getClass();
		
		Field[] fields = maClass.getFields();
		
		String txtJson = "";
		
		for(Field f : fields) {
			f.getName();
			
			Class<?> type = f.getType();
			
			try {
				/* Exemple pour récupérer la valeur du champ selon son type
				if(String.class.isAssignableFrom(type)) {
					String valeur = (String) f.get(o);
				}else if(Integer.class.isAssignableFrom(type)) {
					int valeur = (int) f.get(o);
				}*/
				
				Object valeur = f.get(o);
				
				String format = "\"%s\" = %s";
				
				//si type txt, ajout des " avant et aprés la valeur
				if(String.class.isAssignableFrom(type)) {
					format = "\"%s\" = \"%s\"";
				}
				
				txtJson += String.format(format, f.getName(), valeur);
				
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return txtJson;
	}
}
