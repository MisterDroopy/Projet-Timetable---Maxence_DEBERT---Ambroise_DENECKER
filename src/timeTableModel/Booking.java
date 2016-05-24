/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Booking.
 * 
 * @author ambroise
 */
public class Booking {

	protected String login = "";
	protected int ID_Books = 0;
	protected int ID_Room = 0;
	protected Date date_fin = new Date();
	//public HashSet<Room> rooms = new HashSet<Room>();
	protected Date date_debut = new Date();

	// Start of user code (user defined attributes for Booking)

	// End of user code

	/**
	 * The constructor.
	 */
	public Booking(int ID_Books, int ID_Room, String login, Date date_debut, Date date_fin) {
		this.ID_Books = ID_Books;
		this.ID_Room = ID_Room;
		this.login = login;
		this.date_debut = date_debut;
		this.date_fin = date_fin;		
	}

	/**
	 * Description of the method getTeacherLogin.
	 */
	public String getTeacherLogin() {
		return this.login;
	}

	/**
	 * Description of the method getRoom.
	 */
	public int getRoom() {
		return this.ID_Room;
	}

	// Start of user code (user defined methods for Booking)

	// End of user code

	/**
	 * Sets a value to attribute login. 
	 * @param newLogin 
	 */
	public void setLogin(String newLogin) {
		this.login = newLogin;
	}

	/**
	 * Returns ID_Books.
	 * @return ID_Books 
	 */
	public int getID_Books() {
		return this.ID_Books;
	}

	/**
	 * Sets a value to attribute ID_Books. 
	 * @param newID_Books 
	 */
/*	public void setID_Books(int newID_Books) {
		this.ID_Books = newID_Books;
	}*/

	/**
	 * Returns ID_Room.
	 * @return ID_Room 
	 */
/*	public int getID_Room() {
		return this.ID_Room;
	}*/

	/**
	 * Sets a value to attribute ID_Room. 
	 * @param newID_Room 
	 */
/*	public void setID_Room(int newID_Room) {
		this.ID_Room = newID_Room;
	}*/

	/**
	 * Returns date_fin.
	 * @return date_fin 
	 */
	public Date getDate_fin() {
		return this.date_fin;
	}

	/**
	 * Sets a value to attribute date_fin. 
	 * @param newDate_fin 
	 */
	public void setDate_fin(Date newDate_fin) {
		this.date_fin = newDate_fin;
	}

	/**
	 * Returns rooms.
	 * @return rooms 
	 */
/*	public HashSet<Room> getRooms() {
		return this.rooms;
	}*/

	/**
	 * Returns date_debut.
	 * @return date_debut 
	 */
	public Date getDate_debut() {
		return this.date_debut;
	}

	/**
	 * Sets a value to attribute date_debut. 
	 * @param newDate_debut 
	 */
	public void setDate_debut(Date newDate_debut) {
		this.date_debut = newDate_debut;
	}

}
