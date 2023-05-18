package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import exceptions.MaxClientsExceptions;
import utilities.Utilities;

public class Recepcionist extends Person {

	private String login;
	private String password;

	public Recepcionist(String login, String password, IdType idType, int numberID, String name, String lastName,
			String phoneNumber, Date birthDate, int idLocation) {
		super(idType, numberID, name, lastName, phoneNumber, birthDate, idLocation);
		this.login = login;
		this.password = password;
		assignLoginAndPassword();
	}

	public void assignLoginAndPassword() {
		login = Utilities.generateMail(name, lastName);
		password = Utilities.generateRandomPassword();
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int getNumberID() {
		return super.getNumberID();
	}

	public Reservation registerClient(Reservation reservation, Room room, Client client) throws MaxClientsExceptions {
		reservation.addRoomToReservation(room);
		room.assignClientToRoom(client);
		return reservation;
	}

	public void assignClientToRoom(Room room, Client client) throws MaxClientsExceptions {
		room.assignClientToRoom(client);
	}

	/**
	 * Limpia la habitación de clientes
	 * @param room Habitación a limpiar
	 */
	public void cleanRoom(Room room) {
		room.cleanRoom();
	}

	/**
	 * Genera factura de los clientes
	 * @param reservationIn Reservación que pertenece a la factura
	 * @throws IOException Exepción en caso de no ser posible generar la factura
	 */
	public void generateInvoice(Reservation reservationIn) throws IOException {
		ArrayList<Room> roomList = reservationIn.getRoomList();
		for (Room room : roomList) {			
//			CSVWritter.writteFileInvoice(new Invoice(0, getNumberID(), room.getNumberRoom(), room.getNumberPersonRegister(),
//					room.getPricePerson(), room.getTotalPrice(), room.getPriceOfProducts(), room.getTotalPrice()));
		}
	}

	/**
	 * Obtiene la lista de compras de un cliente
	 * @param client cliente que se obtendra su historial de ventas
	 * @return Lista del historial de ventas 
	 */
	public ArrayList<Sale> getSalesHistory(Client client) {
		return client.getSaleList();
	}
}