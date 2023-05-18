package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import exceptions.DataNotFoundException;
import models.Recepcionist;

@ManagedBean
@SessionScoped
public class LoginBean {

	private Control control;
	private String user;
	private String password;
	private Recepcionist recepcionist;

	private static final String INDEX_XHTML_REDIRECT = "/index.xhtml?faces-redirect=true";
	private static final String SESSION_XHTML_REDIRECT = "/pages/createRoom.xhtml?faces-redirect=true";

	public LoginBean() {
		control = new Control();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Recepcionist getRecepcionist() {
		return recepcionist;
	}

	public void setRecepcionist(Recepcionist recepcionist) {
		this.recepcionist = recepcionist;
	}

	public String login() throws DataNotFoundException {
		if (control.login(user, password) != null) {
			HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			control.setRecepcionist(control.login(user, password));
			httpSession.setAttribute("control", control);
			return SESSION_XHTML_REDIRECT;
		} else {
			return INDEX_XHTML_REDIRECT;
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return INDEX_XHTML_REDIRECT;
	}
}
