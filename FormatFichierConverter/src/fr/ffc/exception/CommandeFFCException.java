package fr.ffc.exception;

public class CommandeFFCException extends FFCException {

	public CommandeFFCException() {
		super();
	}

	public CommandeFFCException(String msg) {
		super("Erreur : " + msg + " est une commande inconnue");
	}
	
}
