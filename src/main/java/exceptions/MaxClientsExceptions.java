package exceptions;

public class MaxClientsExceptions extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "N�mero m�ximo de personas alcazado para esta habitaci�n.";
	
	public MaxClientsExceptions() {
		super(MESSAGE);
	}
}