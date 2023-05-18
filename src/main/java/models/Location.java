package models;

public class Location {

	private int idLocation;
	private LocationType typeLocation;
	private String nameLocation;

	public Location(int idLocation, LocationType typeLocation, String nameLocation) {
		this.idLocation = idLocation;
		this.typeLocation = typeLocation;
		this.nameLocation = nameLocation;
	}

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public LocationType getTypeLocation() {
		return typeLocation;
	}

	public void setTypeLocation(LocationType typeLocation) {
		this.typeLocation = typeLocation;
	}

	public String getNameLocation() {
		return nameLocation;
	}

	public void setNameLocation(String nameLocation) {
		this.nameLocation = nameLocation;
	}
}