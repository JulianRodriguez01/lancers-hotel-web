package connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import models.Client;
import models.IdType;
import models.Invoice;
import models.Product;
import models.Recepcionist;
import models.Reservation;
import models.Room;
import models.Sale;
import utilities.Utilities;

public class Additions {

	private static final String SELECT_ROOMS = "SELECT * FROM rooms";
	private static final String SELECT_CLIENTS = "SELECT * FROM clients";
	private static final String SELECT_RECEPCIONISTS = "SELECT * FROM recepcionists";
	private static final String SELECT_PRODUCTS = "SELECT * FROM products";
	private static final String SELECT_INVOICES = "SELECT * FROM invoices";
	private static final String SELECT_RESERVATIONS = "SELECT * FROM reservations";
	private static final String SELECT_SALES = "SELECT * FROM sales";

	private Conexion conexion;

	public Additions() {
		conexion = new Conexion();
	}

	public void createInitialInformation(ArrayList<Client> clientList, ArrayList<Recepcionist> recepcionistList,
			ArrayList<Reservation> reservationList, ArrayList<Room> roomList, ArrayList<Product> productList,
			ArrayList<Sale> saleList, ArrayList<Invoice> invoiceList) {
		readClientsDB(clientList);
		readInvoicesDB(invoiceList);
		readRecepcionistDB(recepcionistList);
		readReservationsDB(reservationList);
		readRoomsDB(roomList);
		readProductsDB(productList);
		readSalesDB(saleList);
	}

	/**
	 * Lectura de la tabla sales de la base de datos
	 * 
	 * @param saleList lista de compras en la que ingresarán los datos de la DB
	 */
	private void readSalesDB(ArrayList<Sale> saleList) {
		try {
			Connection cnn = conexion.connect();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_SALES);
			while (rs.next()) {
				int idSale = rs.getInt(1);
				Date saleDate = rs.getDate(2);
				double total = rs.getDouble(3);
				saleList.add(new Sale(idSale, saleDate, total));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lectura de la tabla rooms de la base de datos
	 * 
	 * @param roomList lista de habitaciones en la que ingresarán los datos de la DB
	 */
	private void readRoomsDB(ArrayList<Room> roomList) {
		try {
			Connection cnn = conexion.connect();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_ROOMS);
			while (rs.next()) {
				int idRoom = rs.getInt(1);
				int numberMaxUsers = rs.getInt(2);
				double price = rs.getDouble(3);
				boolean productBar = rs.getBoolean(4);
				boolean airConditioning = rs.getBoolean(5);
				boolean cableTV = rs.getBoolean(6);
				Room room = new Room(idRoom, numberMaxUsers, price);
				room.setAirConditioning(airConditioning);
				room.setProductBar(productBar);
				room.setCableTV(cableTV);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lectura de la tabla reservations de la base de datos
	 * 
	 * @param reservationList lista de reservaciones en la que ingresarán los datos
	 *                        de la DB
	 */
	private void readReservationsDB(ArrayList<Reservation> reservationList) {
		try {
			Connection cnn = conexion.connect();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_RESERVATIONS);
			while (rs.next()) {
				int idReservation = rs.getInt(1);
				Date dateIn = rs.getDate(2);
				Date dateOut = rs.getDate(3);
				reservationList.add(new Reservation(idReservation, dateIn, dateOut));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lectura de la tabla recepcionist de la base de datos
	 * 
	 * @param recepcionistList lista de recepcionistas en la que ingresarán los
	 *                         datos de la DB
	 */
	private void readRecepcionistDB(ArrayList<Recepcionist> recepcionistList) {
		try {
			Connection cnn = conexion.connect();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_RECEPCIONISTS);
			while (rs.next()) {
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Date birthDate = rs.getDate(4);
				String phoneNumber = rs.getString(5);
				IdType idType = Utilities.getTypeId(rs.getString(6));
				int idRecepcionist = rs.getInt(7);
				String login = rs.getString(8);
				String password = rs.getString(9);
				int location = rs.getInt(10);
				recepcionistList.add(new Recepcionist(login, password, idType, idRecepcionist, firstName, lastName,
						phoneNumber, birthDate, location));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lectura de la tabla products de la base de datos
	 * 
	 * @param productList lista de productos en la que ingresarán los datos de la DB
	 */
	private void readProductsDB(ArrayList<Product> productList) {
		try {
			Connection cnn = conexion.connect();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_PRODUCTS);
			while (rs.next()) {
				int id = rs.getInt(1);
				String nameProduct = rs.getString(2);
				double unitPrice = rs.getInt(3);
				int numberUnits = rs.getInt(4);
				productList.add(new Product(id, nameProduct, numberUnits, unitPrice));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lectura de la tabla invoices de la base de datos
	 * 
	 * @param invoiceList lista de facturas en la que ingresarán los datos de la DB
	 */
	private void readInvoicesDB(ArrayList<Invoice> invoiceList) {
		try {
			Connection cnn = conexion.connect();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_INVOICES);
			while (rs.next()) {
				int idInvoice = rs.getInt(1);
				Date dateInvoice = rs.getDate(2);
				int numberPerson = rs.getInt(3);
				double priceRoom = rs.getDouble(4);
				double priceProducts = rs.getDouble(5);
				double priceGroup = rs.getDouble(6);
				double total = rs.getDouble(7);
				int idRecepcionist = rs.getInt(8);
				int idRoom = rs.getInt(9);
				invoiceList.add(new Invoice(idInvoice, dateInvoice, idRecepcionist, idRoom, numberPerson, priceRoom, priceGroup,
						priceProducts, total));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lectura de la tabla clients de la base de datos
	 * 
	 * @param clientList lista de clientes en la que ingresarán los datos de la DB
	 */
	private void readClientsDB(ArrayList<Client> clientList) {
		try {
			Connection cnn = conexion.connect();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_CLIENTS);
			while (rs.next()) {
				int id = rs.getInt(6);
				String name = rs.getString(2);
				String lastName = rs.getString(3);
				Date birthDate = rs.getDate(4);
				String phoneNumber = rs.getString(5);
				String idType = rs.getString(7);
				int location = rs.getInt(8);
				clientList.add(
						new Client(Utilities.getTypeId(idType), id, name, lastName, phoneNumber, birthDate, location));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}