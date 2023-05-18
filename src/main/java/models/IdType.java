package models;

public enum IdType {

	IDENTIFICATION_CART("Cédula de Ciudadania", "CC"), IDENTITY_CARD("Tarjeta de Identidad", "TI"),
	FOREIGN_ID("Cédula Extranjera", "CE"), PASSPORT("Pasaporte", "PA");

	private final String typeId;
	private final String abreviation;

	private IdType(String typeId, String abreviation) {
		this.typeId = typeId;
		this.abreviation = abreviation;
	}

	String getTypeId() {
		return typeId;
	}
	
	public String getAbreviation() {
		return abreviation;
	}
}