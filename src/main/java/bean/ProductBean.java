package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import models.*;

@ManagedBean
public class ProductBean {

	private int id;
	private String nameProduct;
	private int numberUnits;
	private double unitPrice;
	private Control control;

	public ProductBean() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		control = (Control) httpSession.getAttribute("control");
	}

	public int getId() {
		return id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public int getNumberUnits() {
		return numberUnits;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setNumberUnits(int numberUnits) {
		this.numberUnits = numberUnits;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void addProductList() {
		try {
			control.addProductHotel(new Product(id, nameProduct, numberUnits, unitPrice));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProductList(int idDelete) {
		try {
			control.deleteProduct(idDelete);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}