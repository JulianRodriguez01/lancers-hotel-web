package bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import models.Client;
import models.Invoice;
import models.Product;
import models.Reservation;
import models.Room;

@ManagedBean
public class ListBean {

	private Control control;

	public ListBean() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		control = (Control) httpSession.getAttribute("control");
	}

	public ArrayList<Product> getListProducts() {
		return control.geProductList();
	}

	public ArrayList<Room> getListRooms() {
		return control.getRoomList();
	}
	
	public ArrayList<Invoice> getInvoiceList(){
		return control.getInvoiceList();
	}
	
	public ArrayList<Reservation> getReservationList(){
		return control.getReservationList();
	}
	
	public ArrayList<Client> getClientList(){
		return control.getClientList();
	}
}