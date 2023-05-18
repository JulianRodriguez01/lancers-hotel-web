package exceptions;

public class ExceptionInsufficientQuantity extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Cantidad insuficiente en el inventario.";
	
	public ExceptionInsufficientQuantity() {
		super(MESSAGE);
	}
}