package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import connections.Additions;
import connections.Inserts;
import exceptions.DataNotFoundException;

/*
Prncipal services of Lancers hotel, in web plataform.
*/
public class HotelServices {

	private ArrayList<Client> clientList;
	private ArrayList<Room> roomList;
	private ArrayList<Recepcionist> recepcionistList;
	private ArrayList<Product> productList;
	private ArrayList<Sale> saleList;
	private ArrayList<Invoice> invoiceList;
	private ArrayList<Reservation> reservationList;

	private Additions additions;
	private Inserts inserts;

	/**
	 * Sistema de infromación web para la gestión de reservas del hotel Lancers, Paipa
	 */
	public HotelServices() {
		additions = new Additions();
		inserts = new Inserts();
		clientList = new ArrayList<Client>();
		roomList = new ArrayList<Room>();
		productList = new ArrayList<Product>();
		saleList = new ArrayList<Sale>();
		recepcionistList = new ArrayList<Recepcionist>();
		invoiceList = new ArrayList<Invoice>();
		reservationList = new ArrayList<Reservation>();
		createInitialInformation();
	}

	/**
	 * Crea la información inicial del hotel, tomada de la base de datos
	 */
	public void createInitialInformation() {
		additions.createInitialInformation(clientList, recepcionistList, reservationList, roomList, productList,
				saleList, invoiceList);
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public ArrayList<Recepcionist> getRecepcionistList() {
		return recepcionistList;
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public ArrayList<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}

	public ArrayList<Client> getClientList() {
		return clientList;
	}

	/**
	 * Loguea al recepcionista, a partir del usuario y la contraseña
	 * @param user Usuario que intentará entrar
	 * @param password Contraseña del recepcionista
	 * @return El recepcionista, en caso de ser encontrado
	 * @throws DataNotFoundException En caso de no ser encontrado el recepcionista
	 */
	public Recepcionist loginRecepcionist(String user, String password) throws DataNotFoundException {
		return validateRecepcionist(user, password);
	}

	/**
	 * Valida el usuario y la contraseña del recepcionista
	 * 
	 * @param user Usario del recepcionista que será validado
	 * @param password Contraseña del recepcionista que será validada
	 * @return Retorna el recepcionista en caso de ser correcta la validación
	 * @throws DataNotFoundException En caso de no ser encontrado el recepcionista
	 */
	public Recepcionist validateRecepcionist(String user, String password) throws DataNotFoundException {
		for (Recepcionist recepcionist : recepcionistList) {
			if (recepcionist.getLogin().equals(user)) {
				return recepcionist;
			}
		}
		throw new DataNotFoundException();
	}

	/**
	 * Agrega una reservación
	 * 
	 * @param reservation Reservación que será agregada
	 */
	public void addReservation(Reservation reservation) {
		reservationList.add(reservation);
		inserts.insertReservations(reservation);
	}

	/**
	 * Agrega una habitación al hotel
	 * 
	 * @param room Habitación que será agregada al hotel
	 * @throws Exception En caso de no ser posible la inserción
	 */
	public void addRoomHotel(Room room) throws Exception {
		roomList.add(room);
		inserts.insertRoom(room);
	}
	
	/**
	 * Elimina una habitación, buscandola a partir del número de la habitación
	 * 
	 * @param numberRoom Número de la habitación que será eliminada
	 * @throws NumberFormatException En caso de que el usuario no dijite un caracter
	 *                               valido
	 * @throws DataNotFoundException En caso de no encontrar la habitación
	 */
	public void deleteRoom(int numberRoom) throws NumberFormatException, DataNotFoundException {
		roomList.remove(searchProduct(numberRoom));
//		CSVWritter.writteFileRooms(roomList);
	}
	
	/**
	 * Agrega una factura a la base de datos
	 * @param invoice Factura que será agregada
	 */
	public void addInvoice(Invoice invoice) {
		invoiceList.add(invoice);
		inserts.insertInvoices(invoice);
	}
	
	public void addClient(Client client) {
		clientList.add(client);
		inserts.insertClient(client);
	}

	/**
	 * Busca una habitación a partir del número de habitación
	 * 
	 * @param numberRoom Número de habitación que será buscado
	 * @return Habitación encontrada
	 * @throws DataNotFoundException En caso de no ser encontrado la habitación
	 */
	public Room searchRoom(int numberRoom) throws DataNotFoundException {
		for (Room room : roomList) {
			if (room.getNumberRoom() == numberRoom)
				return room;
		}
		throw new DataNotFoundException();
	}

	/**
	 * Agrega un recepcionista al hotel
	 * 
	 * @param recepcionist Recepcionista que será agregado al hotel
	 * @throws Exception En caso de no ser posible la inserción
	 */
	public void addRecepcionistHotel(Recepcionist recepcionist) throws Exception {
		recepcionistList.add(recepcionist);
	}

	/**
	 * Elimina un recepcionista buscando a partir de su número de identificación
	 * 
	 * @param id
	 * @throws DataNotFoundException
	 * @throws NumberFormatException
	 * @throws IOException           En caso de no ser posible la eliminación
	 */
	public void deleteRecepcionist(int id) throws DataNotFoundException, NumberFormatException, IOException {
		recepcionistList.remove(searchRecepcionist(id));
	}

	/**
	 * Actualiza la información de un recepcionista
	 * 
	 * @param login
	 * @param password
	 * @param idType
	 * @param numberID
	 * @param name
	 * @param lastName
	 * @param phoneNumber
	 * @param birthDate
	 * @param location
	 * @throws DataNotFoundException En caso de no ser encontrado en la búsqueda el
	 *                               recepcionista
	 */
	public void setRecepcionist(String login, String password, IdType idType, int numberID, String name,
			String lastName, String phoneNumber, Date birthDate, int location) throws DataNotFoundException {
		int recepcionistSearch = searchRecepcionist(numberID);
		recepcionistList.set(recepcionistSearch,
				new Recepcionist(login, password, idType, numberID, name, lastName, phoneNumber, birthDate, location));
	}

	/**
	 * Busca un recepcionista a partir de su número de identificación
	 * 
	 * @param id Identificación que será buscada
	 * @return Posición en la lista del recepcionista
	 * @throws DataNotFoundException En caso de no ser encontrado el identificador
	 *                               del recepcionista
	 */
	public int searchRecepcionist(int id) throws DataNotFoundException {
		for (int i = 0; i < recepcionistList.size(); i++) {
			if (recepcionistList.get(i).getNumberID() == id)
				return i;
		}
		throw new DataNotFoundException();
	}

	/**
	 * Agrega un nuevo producto al hotel
	 * 
	 * @param product Producto que será agregado al hotel
	 * @throws Exception Exepción en caso de no ser posible agregar el producto
	 */
	public void addProductHotel(Product product) throws Exception {
		productList.add(product);
		inserts.insertProduct(product);
	}

	/**
	 * Elimina un producton buscando a partir de su identificador
	 * 
	 * @param id Identificador del producto que será eliminado
	 * @throws Exception En caseo de no ser posible la eliminación del producto
	 */
	public void deleteProduct(int id) throws Exception {
		productList.remove(searchProduct(id));
//		CSVWritter.writteFileProducts(productList);
	}

	/**
	 * Actualiza un producto con sus diferentes variables
	 * 
	 * @param id
	 * @param nameProduct
	 * @param numberUnits
	 * @param unitPrice
	 * @throws DataNotFoundException
	 */
	public void setProduct(int id, String nameProduct, int numberUnits, double unitPrice) throws DataNotFoundException {
		productList.set(searchProduct(id), new Product(id, nameProduct, numberUnits, unitPrice));
	}

	/**
	 * Busca productos a partir de su id
	 * 
	 * @param id Identificador de busqueda que será buscado el producto
	 * @return La posición del cliente encontrado
	 * @throws DataNotFoundException Exccepción en caso de no encontrar el cliente
	 */
	public int searchProduct(int id) throws DataNotFoundException {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getId() == id)
				return i;
		}
		throw new DataNotFoundException();
	}

	/**
	 * Asigna una habitación a un cliente
	 * 
	 * @param client cliente que se le asignara una habitación
	 * @param room   habitación que será asignada a uno o varios clientes
	 */
	public void assignRoomToClient(Client client, Room room) {
		client.setRoom(room);
	}
}
