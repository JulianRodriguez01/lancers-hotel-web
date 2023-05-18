package bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import models.*;

@ManagedBean
public class ReservationBean {

	private int idReservation;
	private Date dateIn;
	private Date dateOut;
	private Control control;

	public ReservationBean() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		control = (Control) httpSession.getAttribute("control");
	}

	public int getCode() {
		return idReservation;
	}

	public void setCode(int idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public void addReservation() {
		try {
			control.addReservation(new Reservation(idReservation, dateIn, dateOut));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}