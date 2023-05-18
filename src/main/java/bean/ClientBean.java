package bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.Util;

import models.Client;
import models.IdType;
import utilities.Utilities;

@ManagedBean
public class ClientBean {

	private Control control;
	private IdType idType;
	private int numberID;
	private String abreviation;
	private String name;
	private String lastName;
	private String city;
	private String phoneNumber;
	private Date birthDate;
	private String login;
	private String password;
	private double priceRoom;

	public ClientBean() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		control = (Control) httpSession.getAttribute("control");
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public IdType getIdType() {
		return idType;
	}

	public void setIdType(IdType idType) {
		this.idType = idType;
	}

	public int getNumberID() {
		return numberID;
	}

	public void setNumberID(int numberID) {
		this.numberID = numberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAbreviation() {
		return abreviation;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPriceRoom() {
		return priceRoom;
	}

	public void setPriceRoom(double priceRoom) {
		this.priceRoom = priceRoom;
	}

	public void addClient() {
		control.addClient(new Client(IdType.IDENTIFICATION_CART, numberID, name, lastName, phoneNumber, birthDate, 0));
	}
	
}