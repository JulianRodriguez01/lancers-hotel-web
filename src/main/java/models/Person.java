package models;

import java.util.Date;

public class Person {

	protected IdType idType;
	protected int numberID;
	protected String name;
	protected String lastName;
	protected String phoneNumber;
	protected Date birthDate;
	private int idLocation;

	public Person(IdType idType, int numberID, String name, String lastName, String phoneNumber,
			Date birthDate, int idLocation) {
		this.idType = idType;
		this.idType = idType;
		this.numberID = numberID;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.idLocation = idLocation;
	}

	public IdType getIdType() {
		return idType;
	}

	public int getNumberID() {
		return numberID;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public int getLocation() {
		return idLocation;
	}
}