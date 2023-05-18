package utilities;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncriptKeys {
	
	public static final String ENCRIPT_TYPE = "utf-8";
    
	/**
	 * Encripta las contraseña de los clientes y recepcionistas del hotel
	 * @param password Contraseña que será encriptada
	 * @return Encriptación de la contraseña seleccionada
	 * @throws UnsupportedEncodingException Exepción en caso de no ser posible encriptar/desencriptar la contraseña
	 */
    public static String encript(String password) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(password.getBytes(ENCRIPT_TYPE));
    }
    
    /**
     * Desencripta las contraseña de los clientes y recepcionistas del hotel
     * @param passwordEncript Contraseña que será desencriptada
     * @return Desencriptación de la contraseña seleccionada
     * @throws UnsupportedEncodingException Exepción en caso de no ser posible encriptar/desencriptar la contraseña
     */
    public static String decrypt(String passwordEncript) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(passwordEncript.getBytes());
        return new String(decode, ENCRIPT_TYPE);
    }
}