package fr.ffc.model;

public class FormatFichier {
	private Formats inputFormat;
	private Formats outputFormat = Formats.JSON;
	private String origin;
	private String destination;
	

	public FormatFichier() {
		super();
	}

	public FormatFichier(String origin, String destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}

	public FormatFichier(Formats outputFormat, String origin, String destination) {
		super();
		this.outputFormat = outputFormat;
		this.origin = origin;
		this.destination = destination;
	}

	public String toString() {
		String msg = "Entrée :\n";
		msg += "   Format : " + inputFormat.toString();
		msg += "   Adresse : " + origin;
		msg += "\nSortie :\n";
		msg += "   Format : " + outputFormat.toString();
		msg += "   Adresse : " + destination;
		return msg;
	}
	
	
	
	public Formats getInputFormat() {
		return inputFormat;
	}

	public void setInputFormat(Formats inputFormat) {
		this.inputFormat = inputFormat;
	}

	public Formats getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(Formats outputFormat) {
		this.outputFormat = outputFormat;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	
	
}
