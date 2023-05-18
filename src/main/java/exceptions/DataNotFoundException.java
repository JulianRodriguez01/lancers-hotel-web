package exceptions;

public class DataNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Elemento no encontrado";
	
	public DataNotFoundException() {
		super(MESSAGE);
	}
}