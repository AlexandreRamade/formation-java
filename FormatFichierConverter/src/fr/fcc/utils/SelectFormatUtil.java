package fr.fcc.utils;

import fr.ffc.model.FormatFichier;
import fr.ffc.model.Formats;

public class SelectFormatUtil {
	
	public static final int INPUT_FORMAT = 0;
	public static final int OUTPUT_FORMAT = 1;
	
	
	public static boolean selectFormat(FormatFichier ff, String formatOption, int typeFormat) {
		for(Formats format : Formats.values()) {
			if(formatOption.equals(format.toString())) {
				if(typeFormat == INPUT_FORMAT) {
					ff.setInputFormat(format);
				} else if(typeFormat == OUTPUT_FORMAT) {
					ff.setOutputFormat(format);
				}
				return true;
			}
		}
		return false;
	}
}
