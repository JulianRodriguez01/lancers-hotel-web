package bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import exceptions.DataNotFoundException;
import models.Client;
import models.HotelServices;
import models.Invoice;
import models.Product;
import models.Recepcionist;
import models.Reservation;
import models.Room;

@ManagedBean
@SessionScoped
public class Control {

	private HotelServices hotelServices;
	private Recepcionist recepcionist;

	public Control() {
		hotelServices = new HotelServices();
	}

	public HotelServices getHotelServices() {
		return hotelServices;
	}
	
	public void setHotelServices(HotelServices hotelServices) {
		this.hotelServices = hotelServices;
	}
	
	public Recepcionist getRecepcionist() {
		return recepcionist;
	}
	
	public void setRecepcionist(Recepcionist recepcionist) {
		this.recepcionist = recepcionist;
	}
	
	public ArrayList<Recepcionist> getRecepcionistList() {
		return hotelServices.getRecepcionistList();
	}
	
	public void addRecepcionistHotel(Recepcionist recepcionist) throws Exception {
		hotelServices.addRecepcionistHotel(recepcionist);
	}

	public void deleteRecepcionist(int id) throws DataNotFoundException, NumberFormatException, IOException {
		hotelServices.deleteRecepcionist(id);
	}
	
	public ArrayList<Room> getRoomList() {
		return hotelServices.getRoomList();
	}

	public void addRoomHotel(Room room) throws Exception {
		hotelServices.addRoomHotel(room);
	}

	public void deleteRoom(int numberRoom) throws NumberFormatException, IOException, DataNotFoundException {
		hotelServices.deleteRoom(numberRoom);
	}

	public void addProductHotel(Product product) throws Exception {
		hotelServices.addProductHotel(product);
	}

	public void deleteProduct(int id) throws Exception {
		hotelServices.deleteProduct(id);
	}

	public void setProduct(int id, String nameProduct, int numberUnits, double unitPrice) throws DataNotFoundException {
		hotelServices.setProduct(id, nameProduct, numberUnits, unitPrice);
	}
	
	public void addInvoice(Invoice invoice) throws Exception {
		hotelServices.addInvoice(invoice);
	}

	public ArrayList<Product> geProductList() {
		return hotelServices.getProductList();
	}

	public ArrayList<Invoice> getInvoiceList() {
		return hotelServices.getInvoiceList();
	}
	
	public ArrayList<Reservation> getReservationList() {
		return hotelServices.getReservationList();
	}
	
	public ArrayList<Client> getClientList() {
		return hotelServices.getClientList();
	}
	
	public void addReservation(Reservation reservation) {
		hotelServices.addReservation(reservation);
	}
	
	public void addClient(Client client) {
		hotelServices.addClient(client);
	}
	
	public Recepcionist login(String name, String password) throws DataNotFoundException {
		return hotelServices.validateRecepcionist(name, password);
	}
	
	public void assignRoomToClient(Client client, Room room) {
		hotelServices.assignRoomToClient(client, room);
	}
}
