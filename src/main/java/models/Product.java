package models;

public class Product {

	private int id;
	private String nameProduct;
	private int numberUnits;
	private double unitPrice;

	public Product(int id, String nameProduct, int numberUnits, double unitPrice) {
		this.id = id++;
		this.nameProduct = nameProduct;
		this.numberUnits = numberUnits;
		this.unitPrice = unitPrice;
	}
	
	public int getId() {
		return id;
	}

	public String getNameProduct() {
		return nameProduct;
	}
	
	public int getNumberUnits() {
		return numberUnits;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setNumberUnits(int numberUnits) {
		this.numberUnits = numberUnits;
	}
}