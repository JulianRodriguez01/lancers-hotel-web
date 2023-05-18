package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import models.*;

@ManagedBean
public class RoomBean {

	private int numberRoom;
	private int numberMaxUser;
	private double pricePerson;

	private boolean productBar;
	private boolean airConditioning;
	private boolean cableTV;
	private boolean jacuzzi;
	private Control control;

	public RoomBean() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		control = (Control) httpSession.getAttribute("control");
	}

	public int getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(int numberRoom) {
		this.numberRoom = numberRoom;
	}

	public int getNumberMaxUser() {
		return numberMaxUser;
	}

	public void setNumberMaxUser(int numberMaxUser) {
		this.numberMaxUser = numberMaxUser;
	}

	public double getPricePerson() {
		return pricePerson;
	}

	public void setPricePerson(double pricePerson) {
		this.pricePerson = pricePerson;
	}

	public boolean isProductBar() {
		return productBar;
	}

	public void setProductBar(boolean productBar) {
		this.productBar = productBar;
	}

	public boolean isAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}

	public boolean isCableTV() {
		return cableTV;
	}

	public void setCableTV(boolean cableTV) {
		this.cableTV = cableTV;
	}

	public boolean isJacuzzi() {
		return jacuzzi;
	}

	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public void addRoomToHotel() {
		try {
			control.addRoomHotel(new Room(numberRoom, numberMaxUser, pricePerson));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteRoom(int numberRoomDelete) {
		try {
			control.deleteRoom(numberRoomDelete);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}