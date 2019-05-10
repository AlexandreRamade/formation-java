package fr.fcc.utils;

import java.io.File;
import java.io.IOException;

import fr.ffc.exception.FFCException;
import fr.ffc.exception.FileException;
import fr.ffc.exception.FormatException;
import fr.ffc.model.FormatFichier;

public class SelectFichierUtil {
	
	public static boolean selectFichierEtInputFormat(FormatFichier ff, String origin) {
		try {			
			File f = new File(origin);
	
			if(f.exists() && f.isFile()) {
				ff.setOrigin(origin);

				String extension = f.getName().substring(f.getName().lastIndexOf(".") + 1);
				
				if(SelectFormatUtil.selectFormat(ff, extension, SelectFormatUtil.INPUT_FORMAT)) {
					return true;
				}else {
					throw new FormatException("Le format du fichier n'est pas supporté.");
				}
			}else {
				throw new FileException("Le fichier est introuvable à l'adress indiquée.");
			}
		} catch (FFCException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
