package models;

public enum LocationType {

	CONTINENT(1), COUNTRY(2), CITY(3), DISTRICT(3);

	private final int id;

	private LocationType(int id) {
		this.id = id;
	}

	int getId() {
		return id;
	}
}