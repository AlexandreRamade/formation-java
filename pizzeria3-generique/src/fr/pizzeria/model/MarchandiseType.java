package fr.pizzeria.model;

import java.util.Arrays;

public class MarchandiseType {
	public String type;
	public String[] libelles;

	
	public MarchandiseType(String type, String[] libelles) {
		this.type = type;
		this.libelles = libelles;
	}

	public String toString() {
		String msg = type + " / ";
		int i = 0, lastIndex = libelles.length - 1;
		for(String str : libelles) {
			msg += str;
			if(i < lastIndex) {
				msg += ", ";
			}
			i++;
		}
		return msg;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarchandiseType other = (MarchandiseType) obj;
		if (!Arrays.equals(libelles, other.libelles))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
	
}
