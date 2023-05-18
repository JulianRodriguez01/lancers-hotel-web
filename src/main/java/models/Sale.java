package models;

import java.util.ArrayList;
import java.util.Date;

import exceptions.ExceptionInsufficientQuantity;

public class Sale {

	private int idSale;
	private ArrayList<Product> productList;
	private Date dateSale;
	private double total;

	public Sale(int idSale, Date saleDate, double total) {
		this.idSale = idSale;
		this.dateSale = saleDate;
		this.total = total;
		productList = new ArrayList<Product>();
	}

	public void addProduct(Product product, int quantify) throws ExceptionInsufficientQuantity {
		if (product.getNumberUnits() >= quantify) {
			productList.add(product);
			total += product.getUnitPrice() * quantify;
			product.setNumberUnits(product.getNumberUnits() - quantify);
		} else
			throw new ExceptionInsufficientQuantity();
	}

	public void deleteProduct(Product product) {
		productList.remove(product);
	}

	public int getIdSale() {
		return idSale;
	}
	
	public Date getDateSale() {
		return dateSale;
	}

	public double getTotal() {
		return total;
	}
}