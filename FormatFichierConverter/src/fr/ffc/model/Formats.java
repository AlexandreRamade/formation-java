package fr.ffc.model;

public enum Formats {
	CVS("cvs"),
	JSON("json"),
	YML("yml"),
	XML("xml");
	
	private String format;
	
	private Formats(String format) {
		this.format = format;
	}
	
	public String toString() {
		return this.format;
	}
}
