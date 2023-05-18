package utilities;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncriptKeys {
	
	public static final String ENCRIPT_TYPE = "utf-8";
    
	/**
	 * Encripta las contrase�a de los clientes y recepcionistas del hotel
	 * @param password Contrase�a que ser� encriptada
	 * @return Encriptaci�n de la contrase�a seleccionada
	 * @throws UnsupportedEncodingException Exepci�n en caso de no ser posible encriptar/desencriptar la contrase�a
	 */
    public static String encript(String password) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(password.getBytes(ENCRIPT_TYPE));
    }
    
    /**
     * Desencripta las contrase�a de los clientes y recepcionistas del hotel
     * @param passwordEncript Contrase�a que ser� desencriptada
     * @return Desencriptaci�n de la contrase�a seleccionada
     * @throws UnsupportedEncodingException Exepci�n en caso de no ser posible encriptar/desencriptar la contrase�a
     */
    public static String decrypt(String passwordEncript) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(passwordEncript.getBytes());
        return new String(decode, ENCRIPT_TYPE);
    }
}