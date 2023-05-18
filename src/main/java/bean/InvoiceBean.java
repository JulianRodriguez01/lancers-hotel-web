package bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import models.Invoice;

@ManagedBean
public class InvoiceBean {

	private int idInvoice;
	private Date dateInvoice;
	private int idRecepcionist;
	private int idRoom;
	private int numberPerson;
	private double priceRoom;
	private double priceGroup;
	private double priceProducts;
	private double total;
	
	private Control control;

	public InvoiceBean() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		control = (Control) httpSession.getAttribute("control");
	}
	
	public int getIdInvoice() {
		return idInvoice;
	}

	public Date getDateInvoice() {
		return dateInvoice;
	}
	
	public int getIdRecepcionist() {
		return idRecepcionist;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public int getNumberPerson() {
		return numberPerson;
	}

	public double getPriceRoom() {
		return priceRoom;
	}

	public double getPriceGroup() {
		return priceGroup;
	}

	public double getPriceProducts() {
		return priceProducts;
	}

	public double getTotal() {
		return total;
	}
	
	public void addInvoice() {
		try {
			control.addInvoice(new Invoice(idInvoice, dateInvoice, idRecepcionist, idRoom, numberPerson, priceRoom, priceGroup, priceProducts, total));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}