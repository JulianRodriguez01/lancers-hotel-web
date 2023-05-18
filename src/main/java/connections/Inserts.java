package connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import models.Client;
import models.Invoice;
import models.Product;
import models.Reservation;
import models.Room;

public class Inserts {

	private static final String INSERT_RESERVATIONS = "INSERT INTO reservations (id_invoices, date_invoice, number_person, price_room, price_products, price_group, total, id_recepcionist, comments) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_INTO_CLIENTS = "INSERT INTO clients (id_client, first_name, last_name, birth_date, phone_number, document_number, id_type, id_location, id_reservation) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_INTO_PRODUCTS = "INSERT INTO products (id_product, name_product, unit_price, stock, description) VALUES (?,?,?,?,?)";
	private static final String INSERT_INTO_ROOMS = "INSERT INTO rooms (id_room, number_max_users, price, product_bar, air_conditioning, cable_tv, id_reservation) VALUES (?,?,?,?,?,?,?)";
	private static final String INSERT_INTO_RESERVATION = "INSERT INTO reservations (id_reservation , date_in, date_out) VALUES (?,?,?)";

	private Conexion conexion;

	public Inserts() {
		conexion = new Conexion();
	}

	/**
	 * Agrega los clientes a la base de datos
	 * 
	 * @param client cliente a registrar
	 */
	public void insertClient(Client client) {
		try {
			Connection cnn = conexion.connect();
			PreparedStatement pStm = cnn.prepareStatement(INSERT_INTO_CLIENTS);
			pStm.setInt(1, 0);
			pStm.setString(2, client.getName());
			pStm.setString(3, client.getLastName());
			pStm.setTimestamp(4, new Timestamp(client.getBirthDate().getDate()));
			pStm.setString(5, client.getPhoneNumber());
			pStm.setInt(6, client.getNumberID());
			pStm.setString(7, client.getIdType().getAbreviation());
			pStm.setInt(8, 0);
			pStm.setInt(9, 0);
			pStm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Agrega los productos a la base de datos
	 * 
	 * @param product productos a registrar
	 */
	public void insertProduct(Product product) {
		try {
			Connection cnn = conexion.connect();
			PreparedStatement pStm = cnn.prepareStatement(INSERT_INTO_PRODUCTS);
			pStm.setInt(1, 0);
			pStm.setString(2, product.getNameProduct());
			pStm.setDouble(3, product.getUnitPrice());
			pStm.setInt(4, product.getNumberUnits());
			pStm.setString(5, null);
			pStm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Agrega las habitaciones a la base de datos
	 * 
	 * @param room habitación a registrar
	 */
	public void insertRoom(Room room) {
		try {
			Connection cnn = conexion.connect();
			PreparedStatement pStm = cnn.prepareStatement(INSERT_INTO_ROOMS);
			pStm.setInt(1, room.getNumberRoom());
			pStm.setInt(2, room.getNumberMaxUser());
			pStm.setDouble(3, room.getPricePerson());
			pStm.setBoolean(4, room.isProductBar());
			pStm.setBoolean(5, room.isAirConditioning());
			pStm.setBoolean(6, room.isCableTV());
			pStm.setString(7, null);
			pStm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Agrega las reservas a la base de datos
	 * 
	 * @param reservation reserva a registrar
	 */
	public void insertReservations(Reservation reservation) {
		try {
			Connection cnn = conexion.connect();
			PreparedStatement pStm = cnn.prepareStatement(INSERT_INTO_RESERVATION);
			pStm.setInt(1, 0);
			pStm.setDate(2, (java.sql.Date) reservation.getDateIn());
			pStm.setDate(3, (java.sql.Date) reservation.getDateOut());
			pStm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Agrega las facturas creadas a la base de datos
	 * 
	 * @param invoice factura a registrar
	 */
	public void insertInvoices(Invoice invoice) {
		try {
			Connection cnn = conexion.connect();
			PreparedStatement pStm = cnn.prepareStatement(INSERT_RESERVATIONS);
			pStm.setInt(1, 0);
			pStm.setDate(2, (java.sql.Date) invoice.getDateInvoice());
			pStm.setInt(3, invoice.getNumberPerson());
			pStm.setDouble(4, invoice.getPriceRoom());
			pStm.setDouble(5, invoice.getPriceProducts());
			pStm.setDouble(6, invoice.getPriceGroup());
			pStm.setDouble(7, invoice.getTotal());
			pStm.setInt(8, invoice.getIdRecepcionist());
			pStm.setString(9, null);
			pStm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	readRecepcionistDB(recepcionistList);
//	readSalesDB(saleList);
}