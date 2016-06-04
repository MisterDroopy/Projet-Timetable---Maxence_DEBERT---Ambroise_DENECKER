/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;

/**
 * Cette classe permet de gérer les réservations.
 * 
 * @author Maxence Debert - Ambroise Denecker
 * @version 06/2016
 */
public class Booking {

	protected String login = "";
	protected int ID_Books = 0;
	protected int ID_Room = 0;
	protected Date date_fin = new Date();
	protected Date date_debut = new Date();


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


	/**
	 * Returns ID_Books.
	 * 
	 * @return ID_Books
	 */
	public int getID_Books() {
		return this.ID_Books;
	}

	
	/**
	 * Returns date_fin.
	 * 
	 * @return date_fin
	 */
	public Date getDate_fin() {
		return this.date_fin;
	}


	/**
	 * Returns date_debut.
	 * 
	 * @return date_debut
	 */
	public Date getDate_debut() {
		return this.date_debut;
	}


}
