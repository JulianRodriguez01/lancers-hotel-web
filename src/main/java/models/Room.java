package models;

import java.util.ArrayList;

import exceptions.MaxClientsExceptions;

public class Room {

	private int numberRoom;
	private int numberMaxUser;
	private double pricePerson;

	private boolean productBar;
	private boolean airConditioning;
	private boolean cableTV;
	private ArrayList<Client> clientList;

	public Room(int numberRoom, int numberMaxUser, double pricePerson) {
		this.numberRoom = numberRoom;
		this.numberMaxUser = numberMaxUser;
		this.pricePerson = pricePerson;
		clientList = new ArrayList<Client>();
	}

	public int getNumberRoom() {
		return numberRoom;
	}

	public int getNumberMaxUser() {
		return numberMaxUser;
	}

	public double getPricePerson() {
		return pricePerson;
	}

	public ArrayList<Client> getClientList() {
		return clientList;
	}

	public boolean isProductBar() {
		return productBar;
	}

	public boolean isAirConditioning() {
		return airConditioning;
	}

	public boolean isCableTV() {
		return cableTV;
	}

	public void setProductBar(boolean productBar) {
		this.productBar = productBar;
	}

	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}

	public void setCableTV(boolean cableTV) {
		this.cableTV = cableTV;
	}

	public int getNumberPersonRegister() {
		return clientList.size();
	}

	public void assignClientToRoom(Client client) throws MaxClientsExceptions {
		if (clientList.size() + 1 <= numberMaxUser) {
			client.setPriceRoom(pricePerson);
			clientList.add(client);
		} else {
			throw new MaxClientsExceptions();
		}
	}

	/**
	 * Borra los clientes de la habitación
	 */
	public void cleanRoom() {
		for (Client client : clientList) {
			clientList.remove(client);
		}
	}

	/**
	 * Obtiene el precio de los productos de la habitación
	 * @return
	 */
	public double getPriceOfProducts() {
		double total = pricePerson * getNumberPersonRegister();
		for (Client client : clientList) {
			total += client.getTotalSales();
		}
		return total;
	}

	public double getTotalPrice() {
		double total = pricePerson * getNumberPersonRegister();
		total += getPriceOfProducts();
		return total;
	}
}