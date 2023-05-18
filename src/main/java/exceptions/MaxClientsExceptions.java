package exceptions;

public class MaxClientsExceptions extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Número máximo de personas alcazado para esta habitación.";
	
	public MaxClientsExceptions() {
		super(MESSAGE);
	}
}