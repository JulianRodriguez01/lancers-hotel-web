package models;

import java.util.ArrayList;
import java.util.Date;

import exceptions.ExceptionInsufficientQuantity;
import utilities.Utilities;

public class Client extends Person {

	private String login;
	private String password;
	private ArrayList<Sale> saleList;
	private String abreviation;
	private double priceRoom;
	private Room Room;

	public Client(IdType idType, int numberID, String name, String lastName, String phoneNumber, Date birthDate, int idLocation) {
		super(idType, numberID, name, lastName, phoneNumber, birthDate, idLocation);
		saleList = new ArrayList<Sale>();
		login = Utilities.generateMail(name, lastName);
		password = Utilities.generateRandomPassword();
		abreviation = idType.getAbreviation();
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public String getAbreviation() {
		return abreviation;
	}

	public ArrayList<Sale> getSaleList() {
		return saleList;
	}

	public void setPriceRoom(double priceRoom) {
		this.priceRoom = priceRoom;
	}

	public Room getRoom() {
		return Room;
	}

	public void setRoom(Room room) {
		Room = room;
	}

	/*
	 * Agrega una venta a la facutura perteneciente a un cliente (Una venta)
	 */
	public void addSale(Sale sale) {
		saleList.add(sale);
	}

	/*
	 * Agrega un producto a la compra perteneciente a un cliente (Una venta) 
	 */
	public void buyProduct(Sale sale, Product product, int quantify) throws ExceptionInsufficientQuantity {
		sale.addProduct(product, quantify);
	}

	/*
	 * Obtiene el valor total de las compras
	 * @return Valor total de las compras
	 */
	public double getTotalSales() {
		double totalSales = 0;
		for (Sale sale : saleList) {
			totalSales += sale.getTotal();
		}
		return totalSales;
	}

	/*
	 * Obtiene el valor total del cliente
	 * @return Valor total del cliente
	 */
	public double checkCurrentSpending() {
		return getTotalSales() + priceRoom;
	}
	
	public IdType getIdTypeForAbreviation(String text) {
		return Utilities.getTypeId(text);
	}
}