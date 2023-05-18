package models;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
	
	private int idReservation;
	private Date dateIn;
	private Date dateOut;
	private ArrayList<Room> roomList;

	public Reservation(int idReservation, Date dateIn, Date dateOut) {
		this.idReservation = idReservation;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		roomList = new ArrayList<Room>();
	}

	public int getIdReservation() {
		return idReservation;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}
	
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	
	public void addRoomToReservation(Room room) {
		roomList.add(room);
	}
}