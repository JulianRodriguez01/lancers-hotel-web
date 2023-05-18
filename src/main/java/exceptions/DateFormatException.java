package exceptions;

public class DateFormatException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Error en el formato, Formato: dd/MM/yyyy";
	
	public DateFormatException() {
		super(MESSAGE);
	}
}