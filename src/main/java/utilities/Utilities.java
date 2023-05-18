package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.DateFormatException;
import models.IdType;
import models.LocationType;

public class Utilities {

	private static final String FORMAT_DATE_IN = "MM-dd-yyyy";
	private static final int NUMBER_CHARACTERS = 4;
	private static final String IDENTIFICATOR_PA = "PA";
	private static final String IDENTIFICATOR_TI = "TI";
	private static final String IDENTIFICATOR_CE = "CE";
	private static final String IDENTIFICATOR_CC = "CC";
	private static final String POINT = ".";
	private static final String HOTEL_EXTENSION = "@lancers.com";
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public static final String FORMAT_DATE_ES = "d/M/yyyy";
	public static final String FORMAT_DATE_EN = "yyyy-MM-d";
	public static final String FORMAT_DATE = "\\d{1,2}/\\d{1,2}/\\d{4}";

	/**
	 * Obtiene el tipo de identificaci�n a partir de una abreviaci�n
	 * @param value abreviatura que ser� convertida en un tipo de identificaci�n
	 * @return El tipo de identificaci�n
	 */
	/**
	 * @param value
	 * @return
	 */
	public static IdType getTypeId(String value) {
		switch (value) {
		case IDENTIFICATOR_CC:
			return IdType.IDENTIFICATION_CART;
		case IDENTIFICATOR_CE:
			return IdType.FOREIGN_ID;
		case IDENTIFICATOR_TI:
			return IdType.IDENTITY_CARD;
		case IDENTIFICATOR_PA:
			return IdType.PASSPORT;
		}
		return null;
	}
	
	/**
	 * Obtiene el tipo de localizaci�n a partir de una abreviaci�n
	 * @param value abreviatura que ser� convertida en un tipo de localizaci�n
	 * @return El tipo de localizaci�n
	 */
	public static LocationType getTypeId(int value) {
		switch (value) {
		case 1:
			return LocationType.CONTINENT;
		case 2:
			return LocationType.COUNTRY;
		case 3:
			return LocationType.CITY;
		case 4:
			return LocationType.DISTRICT;
		}
		return null;
	}

	/**
	 * M�todo que convierte un texto en una fecha, a partir de un formato
	 * @param stringDate Texto que se convertira en una fecha
	 * @param format Formato a convertir el texto en fecha
	 * @return Fecha convertida
	 * @throws ParseException Excepci�n en caso de no ser posible la conversi�n
	 */
	public static Date toDate(String stringDate, String format) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE_IN);
		return  simpleDateFormat.parse(stringDate);
	}

	/**
	 * Validaci�n que la fecha se encuentra en el formato correcto
	 * @param dateString Fecha en texto a ser validada
	 * @return Retorna true en caso de estar en un formato correcto la fecha
	 * @throws DateFormatException Excepci�n en caso de estar incorrecto el formato de entrada
	 */
	public static boolean validateDate(String dateString) throws DateFormatException {
		Pattern pat = Pattern.compile(FORMAT_DATE);
		Matcher mat = pat.matcher(dateString);
		if (mat.matches())
			return true;
		throw new DateFormatException();
	}

	/**
	 * Genera el correo autogenerado del hotel
	 * @param name Nombre del cliente al que se le autogenera el correo
	 * @param lastName Apellido del cliente al que se le autogenera el correo
	 * @return El correo del cliente registrado
	 */
	public static String generateMail(String name, String lastName) {
		return name.toLowerCase() + POINT + lastName.toLowerCase() + HOTEL_EXTENSION;
	}

	/**
	 * Genera n�meros aleatorios, para luego comvertirlos en una contrase�a
	 * @param min N�mero m�nimo que ser� generado el n�mero aleatorio 
	 * @param max N�mero m�ximo que ser� generado el n�mero aleatorio
	 * @return N�mero aleatorio 
	 */
	public static int generateRandomNumber(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	/**
	 * Genera una contrase�a aleatoria al cliente registrado
	 * @return Contrase�a aleatoria
	 */
	public static String generateRandomPassword() {
		String password = "";
		for (int i = 0; i < NUMBER_CHARACTERS; i++) {
			int randomNumber = generateRandomNumber(0, CHARACTERS.length() - 1);
			char randomChar = CHARACTERS.charAt(randomNumber);
			password += randomChar;
		}
		return password;
	}
}