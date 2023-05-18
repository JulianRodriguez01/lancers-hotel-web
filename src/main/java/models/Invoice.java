package models;

import java.util.Date;

public class Invoice {

	private int idInvoice;
	private Date dateInvoice;
	private int idRecepcionist;
	private int idRoom;
	private int numberPerson;
	private double priceRoom;
	private double priceGroup;
	private double priceProducts;
	private double total;

	public Invoice(int idInvoice, Date dateInvoice, int idRecepcionist, int idRoom, int numberPerson, double priceRoom, double priceGroup,
			double priceProducts, double total) {
		this.idInvoice = idInvoice;
		this.dateInvoice = dateInvoice;
		this.idRecepcionist = idRecepcionist;
		this.idRoom = idRoom;
		this.numberPerson = numberPerson;
		this.priceRoom = priceRoom;
		this.priceGroup = priceGroup;
		this.priceProducts = priceProducts;
		this.total = total;
	}
	
	public int getIdInvoice() {
		return idInvoice;
	}

	public Date getDateInvoice() {
		return dateInvoice;
	}
	
	public int getIdRecepcionist() {
		return idRecepcionist;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public int getNumberPerson() {
		return numberPerson;
	}

	public double getPriceRoom() {
		return priceRoom;
	}

	public double getPriceGroup() {
		return priceGroup;
	}

	public double getPriceProducts() {
		return priceProducts;
	}

	public double getTotal() {
		return total;
	}
}